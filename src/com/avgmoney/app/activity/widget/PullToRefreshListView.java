package com.avgmoney.app.activity.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class PullToRefreshListView extends ListView {
    private static final String TAG = "PullToRefreshListView";

    private static final int TAP_TO_REFRESH = 1; // 默认状态
    private static final int PULL_TO_REFRESH = 2;// 下拉刷新
    private static final int RELEASE_TO_REFRESH = 3;// 向上
    private static final int REFRESHING = 4;// 刷新
    private int mCurrentScrollState;
    private int mRefreshState;

    public PullToRefreshListView(Context context) {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}
