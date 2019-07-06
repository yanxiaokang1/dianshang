package bawei.com.yanxiaokang20190703.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190703
 *@Description:适配器
 * */public class MyAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public MyAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
