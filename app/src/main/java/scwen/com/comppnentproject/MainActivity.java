package scwen.com.comppnentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;

import junit.framework.Test;

import org.greenrobot.eventbus.EventBus;

import scwen.com.module_cart.ShopCartActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().post("ghh");


    }

    public void toCart(View view) {
        // 2. 跳转并携带参数
        ARouter.getInstance().build("/com/Activity1")
                .navigation();
    }
}
