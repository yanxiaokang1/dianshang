package bawei.com.yanxiaokang20190703.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bawei.com.yanxiaokang20190703.R;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190703
 *@Description:
 * */public class Fragment04 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment04, container, false);
        return inflate;
    }
}
