package bawei.com.yanxiaokang20190703.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import bawei.com.yanxiaokang20190703.Http;
import bawei.com.yanxiaokang20190703.MyList;
import bawei.com.yanxiaokang20190703.R;
import bawei.com.yanxiaokang20190703.adapter.Mya;
import bawei.com.yanxiaokang20190703.bean.Bean;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190703
 *@Description:
 * */public class Fragment01 extends Fragment {

    private Banner banner;
    private Http http = Http.getInstance();
    private ArrayList<String> list = new ArrayList<>();
    private MyList xlv;
    private PullToRefreshScrollView pull;
    private ArrayList<Bean> list1 = new ArrayList<>();
    private Mya mya;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment01, container, false);
        banner = inflate.findViewById(R.id.banner);
        initView(inflate);
        inData();//轮播图
        inlv();//多条目
        insx();//刷新
        inwl();//网络

        return inflate;
    }

    //网络判断
    private void inwl() {
        boolean isnewwordConcted = http.isnewwordConcted(getActivity());
        if (isnewwordConcted) {
            inData();
            inlv();
            insx();
            Toast.makeText(getActivity(), "有网", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "没网", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView(View inflate) {
        xlv = (MyList) inflate.findViewById(R.id.xlv);
        pull = (PullToRefreshScrollView) inflate.findViewById(R.id.pull);
    }

    //刷新
    private void insx() {
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                mya = null;
                list1.clear();
                inData();
                inlv();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                inData();
                inlv();
            }
        });
    }

    //展示多条目
    private void inlv() {
        http.getInstance();
        http.getString("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1", new Http.CallBackString() {


            @Override
            public void getString(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONObject data = object.optJSONObject("data");
                    JSONArray news = data.getJSONArray("news");
                    for (int i = 0; i < news.length(); i++) {
                        JSONObject object1 = (JSONObject) news.get(i);
                        String imageUrl = object1.getString("imageUrl");
                        String publishAt = object1.getString("publishAt");
                        String title = object1.getString("title");
                        list1.add(new Bean(imageUrl, publishAt, title));
                        Collections.shuffle(list1);
                        mya = new Mya(getActivity(), list1);
                        xlv.setAdapter(mya);
                        mya.notifyDataSetChanged();
                        pull.onRefreshComplete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //轮播图
    private void inData() {
        http.getInstance();
        http.getString("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1", new Http.CallBackString() {
            @Override
            public void getString(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONObject data = object.optJSONObject("data");
                    JSONArray news = data.getJSONArray("news");
                    for (int i = 0; i < news.length(); i++) {
                        JSONObject object1 = (JSONObject) news.get(i);
                        String imageUrl = object1.getString("imageUrl");
                        list.add(imageUrl);
                    }
                    Collections.shuffle(list);
                    banner.setImages(list);
                    banner.isAutoPlay(true);
                    banner.setDelayTime(2000);
                    banner.setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            String da = "http://blog.zhaoliang5156.cn/zixunnew/" + path;
                            Glide.with(context).load(da).into(imageView);
                        }
                    });
                    banner.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
