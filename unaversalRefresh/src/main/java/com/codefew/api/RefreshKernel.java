package com.codefew.api;

import android.support.annotation.NonNull;

import com.codefew.status.RefreshState;

/**
 * Created by flowing on 2018/2/7.
 */

public interface RefreshKernel {

    /**
     * @return 获取刷新的主接口
     */
    @NonNull
    Refreshable getRefreshLayout();

    /**
     * 获取刷新内部组件接口
     *
     * @return
     */
    @NonNull
    RefreshContentable getRefreshContent();


    /**
     * 设置刷新的状态
     *
     * @param state
     * @return
     */
    RefreshKernel setState(@NonNull RefreshState state);


    /**
     * 开始执行二极刷新
     *
     * @param open 是否展开
     * @return
     */
    RefreshKernel startTwoLevel(boolean open);

    /**
     * 结束关闭二极刷新
     *
     * @return
     */
    RefreshKernel finishTwoLevel();

    /**
     * 移动视图到指定位置
     * moveSpinner 的取名来自 谷歌官方的 @{@link android.support.v4.widget.SwipeRefreshLayout#moveSpinner(float)}
     *
     * @param spinner    位置 (px)
     * @param isAnimator 标记是否是动画执行
     * @return
     */
    RefreshKernel moveSpinner(int spinner, boolean isAnimator);

    /**
     * 执行动画使视图位移到指定的 位置
     * moveSpinner 的取名来自 谷歌官方的 @{@link android.support.v4.widget.SwipeRefreshLayout#moveSpinner(float)}
     *
     * @param endSpinner 指定的结束位置 (px)
     * @return
     */
    RefreshKernel animSpinner(int endSpinner);


    /**
     * 指定在下拉时候为 Header 绘制背景
     *
     * @param backgroundColor 背景颜色
     * @return
     */
    RefreshKernel requestDrawBackgoundForHeader(int backgroundColor);

    /**
     * 指定在下拉时候为 Footer 绘制背景
     *
     * @param backgroundColor 背景颜色
     * @return
     */
    RefreshKernel requestDrawBackgoundForFooter(int backgroundColor);



    /**
     * 请求事件 当下拉刷新时请求header touch事件
     * @param request
     * @return
     */
    RefreshKernel requestHeaderNeedTouchEventWhenRefreshing(boolean request);

    /**
     * 请求事件 当加载更多的时请求footer touch事件
     * @param request
     * @return
     */
    RefreshKernel requestFooterNeedTouchEventWhenLoading(boolean request);

    /**
     * 请求设置默认内容滚动设置
     * @param translation
     * @return
     */
    RefreshKernel requestDefaultHeaderTranslationContent(boolean translation);

    /**
     * 请求重新测量  header
     * @return
     */
    RefreshKernel requestRemeasureHeightForHeader();

    /**
     * 请求重新测量  footer
     * @return
     */
    RefreshKernel requestRemeasureHeightForFooter();

    /**
     * 设置二楼回弹时长
     * @param duration
     * @return
     */
    RefreshKernel requestFloorDuration(int duration);

}
