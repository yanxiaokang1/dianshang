package bawei.com.yanxiaokang20190703;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import bawei.com.yanxiaokang20190703.adapter.MyAdapter;
import bawei.com.yanxiaokang20190703.fragment.Fragment01;
import bawei.com.yanxiaokang20190703.fragment.Fragment02;
import bawei.com.yanxiaokang20190703.fragment.Fragment03;
import bawei.com.yanxiaokang20190703.fragment.Fragment04;
import bawei.com.yanxiaokang20190703.fragment.Fragment05;

public class MainActivity extends BaseActivity{

    private TabLayout tab;
    private ViewPager vp;
    private ImageView im;
    private ArrayList<Fragment> list = new ArrayList<>();
    private MyAdapter myAdapter;



    protected void init1() {
        list.add(new Fragment01());
        list.add(new Fragment02());
        list.add(new Fragment03());
        list.add(new Fragment04());
        list.add(new Fragment05());
        myAdapter = new MyAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(myAdapter);
        tab.setupWithViewPager(vp);
        Log.i("aaa", "init1: "+list);
        tab.getTabAt(0).setText("风景");
        tab.getTabAt(1).setText("美女");
        tab.getTabAt(2).setText("动漫卡通");
        tab.getTabAt(3).setText("娱乐明星");
        tab.getTabAt(4).setText("萌宠");
    }

    protected void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        im = (ImageView) findViewById(R.id.im);
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }

    //相册
    public void xc(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10 && resultCode == RESULT_OK) {
            Uri data1 = data.getData();
            Glide.with(MainActivity.this).load(data1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(im);
        }
    }
}
