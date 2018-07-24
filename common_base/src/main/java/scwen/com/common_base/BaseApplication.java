package scwen.com.common_base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

/**
 * Created by scwen on 2018/7/24.
 * QQ ：811733738
 * 作用：
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "BaseApplication onCreate");


        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化



        String packageName = getApplicationInfo().packageName;
        Log.e("TAG", "packageName:" + packageName);
        String curProcessName = getCurProcessName(this);
        Log.e("TAG", "curProcessName:" + curProcessName);

        if (!BuildConfig.isModule) {
            List<String> strings = JsonUtils.parseAssetsJson2List(String.class, this, "json/application.json");

            if (strings != null && strings.size() > 0) {

                for (String classStr : strings) {

                    try {
                        Class<AppInitAction> clazz = (Class<AppInitAction>) Class.forName(classStr);
                        AppInitAction initAction = clazz.newInstance();
                        initAction.onCreate(this);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }


            }


        }


    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
