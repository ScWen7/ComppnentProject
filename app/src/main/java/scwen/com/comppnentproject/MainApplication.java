package scwen.com.comppnentproject;

import android.util.Log;

import scwen.com.common_base.BaseApplication;

/**
 * Created by scwen on 2018/7/24.
 * QQ ：811733738
 * 作用：
 */

public class MainApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "MainApplication  onCreate");
    }
}
