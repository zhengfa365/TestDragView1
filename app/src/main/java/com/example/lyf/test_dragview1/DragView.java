package com.example.lyf.test_dragview1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by lyf on 2017/4/9.
 */

public class DragView extends Button{
    private int mLastX;
    private int mLastY;
    private Context mContext;
    public DragView(Context context) {
        this(context,null);
        mContext=context;
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getRawX();       //获取view在屏幕上的坐标
        int y= (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int delX=x-mLastX;          //和上一次滑动事件的距离
                int delY=y-mLastY;
                int transX=(int)getTranslationX()+delX;     //以前移动的距离加上现在移动的距离
                int transY=(int)getTranslationY()+delY;
                setTranslationX(transX);
                setTranslationY(transY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastX=x;
        mLastY=y;
        return false;
    }



}
