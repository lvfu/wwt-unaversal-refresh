package com.codefew.api;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by flowing on 2018/2/7.
 * @author wangwentao
 * @version 1.0
 * 刷新内部控件
 */

public interface RefreshContentable {


    /**
     * 移动微调
     * @param spinner
     */
    void moveSpinner(int spinner);

    /**
     *
     *是否可以刷新
     * @return
     */
    boolean canRefresh();

    /**
     * 是否可以加载
     * @return
     */
    boolean canLoadmore();

    /**
     * 获取Measure 宽度
     * @return
     */
    int getMeasuredWidth();

    /**
     * 获取Measure 高度
     * @return
     */
    int getMeasuredHeight();

    /**
     *测量
     * @param widthSpec
     * @param heightSpec
     */
    void measure(int widthSpec, int heightSpec);

    /**
     * 布局
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    void layout(int left, int top, int right, int bottom);

    /**
     * 获取view
     * @return
     */
    View getView();

    /**
     * 获取可以滚动的view
     * @return
     */
    View getScrollableView();

    /**
     *
     * 获取布局参数
     * @return
     */
    ViewGroup.LayoutParams getLayoutParams();

    /**
     *按下动作
     *
     * @param e
     */

    void onActionDown(MotionEvent e);

    /**
     * up或者Cancel 的动作
     */
    void onActionUpOrCancel();

    /**
     * 飞行的速度
     *
     * @param velocity
     */
    void flying(int velocity);

    /**
     *
     * 设置向上组件
     *
     * @param kernel
     * @param fixedHeader
     * @param fixedFooter
     */
    void setUpComponent(RefreshKernel kernel, View fixedHeader, View fixedFooter);

    /**
     * 初始化header高度和footer高度
     *
     * @param headerHeight
     * @param footerHeight
     */
    void onInitialHeaderAndFooter(int headerHeight, int footerHeight);

    /**
     *
     * 设置边界
     * @param boundary
     */
    void setScrollBoundaryDecider(ScrollBoundaryDecider boundary);

    /**
     *
     *
     * 内容不足一页的时候设置加载更多
     * @param enable
     */

    void setEnableLoadmoreWhenContentNotFull(boolean enable);

    /**
     *
     * 设置当完成滚动后的spinner
     * @param spinner
     * @return
     */

    ValueAnimator.AnimatorUpdateListener scrollContentWhenFinished(int spinner);



}


