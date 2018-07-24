package scwen.com.module_cart;

import android.app.Application;
import android.util.Log;

import scwen.com.common_base.AppInitAction;

/**
 * Created by scwen on 2018/7/24.
 * QQ ：811733738
 * 作用：
 */

public class CartAppInitAction implements AppInitAction {
    @Override
    public void onCreate(Application application) {
        Log.e("TAG", "cart init action:" + application);
    }
}
