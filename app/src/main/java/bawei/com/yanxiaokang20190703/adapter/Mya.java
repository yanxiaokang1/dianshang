package bawei.com.yanxiaokang20190703.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import bawei.com.yanxiaokang20190703.R;
import bawei.com.yanxiaokang20190703.bean.Bean;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190617
 *@Description:
 * */public class Mya extends BaseAdapter {
    private Context context;
    private ArrayList<Bean> list;

    public Mya(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)){
            case 0:
                ViewHorder01 horder01;
                if (view==null){
                    view=View.inflate(context,R.layout.item,null);
                    horder01 = new ViewHorder01();
                    horder01.textView=view.findViewById(R.id.textview);
                    horder01.imageView=view.findViewById(R.id.imageview);
                    horder01.publishAt=view.findViewById(R.id.publishAt);
                    view.setTag(horder01);
                }else{
                    horder01=(ViewHorder01) view.getTag();
                }
                horder01.textView.setText(list.get(i).getTitle());
                horder01.publishAt.setText(list.get(i).getPublishAt());
                Glide.with(context).load("http://blog.zhaoliang5156.cn/zixunnew/"+list.get(i).getImageUrl()).into(horder01.imageView);

                break;
            case 1:
                ViewHorder02 horder02;
                if (view==null){
                    view=View.inflate(context,R.layout.item1,null);
                    horder02 = new ViewHorder02();
                    horder02.textView01=view.findViewById(R.id.textview01);
                    horder02.imageView01=view.findViewById(R.id.imageview01);
                    horder02.publishAt01=view.findViewById(R.id.publishAt01);
                    view.setTag(horder02);
                }else{
                    horder02=(ViewHorder02) view.getTag();
                }
                horder02.textView01.setText(list.get(i).getTitle());
                horder02.publishAt01.setText(list.get(i).getPublishAt());
                Glide.with(context).load("http://blog.zhaoliang5156.cn/zixunnew/"+list.get(i).getImageUrl()).into(horder02.imageView01);
                break;
        }
        return view;
    }

    static class ViewHorder01 {
        TextView textView;
        ImageView imageView;
        TextView publishAt;
    }

    static class ViewHorder02 {
        TextView textView01;
        ImageView imageView01;
        TextView publishAt01;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
