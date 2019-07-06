package bawei.com.yanxiaokang20190703;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/*
 *@Auther:闫小康
 *@Date: 2019年
 *@Time:20190703
 *@Description:
 * */public class MyList extends ListView {
    public MyList(Context context) {
        super(context);
    }

    public MyList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
