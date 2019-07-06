package bawei.com.yanxiaokang20190703;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190617
 *@Description:
 * */public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        initView();
        init1();



    }

    protected abstract void init1();

    protected abstract void initView();
    protected abstract int initlayout();
}
