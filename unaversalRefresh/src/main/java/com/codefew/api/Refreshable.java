package com.codefew.api;

import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.codefew.listener.OnLoadmoreListener;
import com.codefew.listener.OnMultiPurposeListener;
import com.codefew.listener.OnRefreshListener;
import com.codefew.listener.OnRefreshLoadmoreListener;
import com.codefew.status.RefreshState;

/**
 * Created by flowing on 2018/2/6.
 * @author wangwentao
 * @version 1.0
 *
 * 全局的接口使用
 */

public interface Refreshable {


    /**
     * 设置footer高度
      * @param dp
     * @return
     */
    Refreshable setFooterHeight(float dp);

    /**
     * 设置footer 高度
     *
     * @param px
     * @return
     */

    Refreshable setFooterHeightPx(int px);

    /**
     *
     * 设置header 高度
     * @param dp
     * @return
     */

    Refreshable setHeaderHeight(float dp);

    /**
     *
     * 设置header高度
     * @param px
     * @return
     */

    Refreshable setHeaderHeightPx(int px);


    /**
     * 显示拖动高度/真实拖动高度（默认0.5，阻尼效果）
     * @param rate
     * @return
     */
    Refreshable setDragRate(float rate);



    /**
     *
     * 设置下拉最大高度和Header高度的比率（将会影响可以下拉的最大高度）
     * @param rate
     * @return
     */
    Refreshable setHeaderMaxDragRate(float rate);


    /**
     *
     * 设置上啦最大高度和Footer高度的比率（将会影响可以上啦的最大高度）
     * @param rate
     * @return
     */
    Refreshable setFooterMaxDragRate(float rate);



    /**
     * 设置 触发刷新距离 与 HeaderHieght 的比率
     *
     * @param rate
     * @return
     */
    Refreshable setHeaderTriggerRate(float rate);



    /**
     *
     * 设置 触发加载距离 与 FooterHieght 的比率
     * @param rate
     * @return
     */
    Refreshable setFooterTriggerRate(float rate);


    /**
     *
     * 设置回弹显示插值器
     * @param interpolator
     * @return
     */
    Refreshable setReboundInterpolator(Interpolator interpolator);



    /**
     *
     * 设置回弹动画时长
     * @param duration
     * @return
     */
    Refreshable setReboundDuration(int duration);



    /**
     *
     * 设置是否启用上啦加载更多（默认启用）
     * @param enable
     * @return
     */
    Refreshable setEnableLoadmore(boolean enable);


    /**
     * 是否启用下拉刷新（默认启用）
     *
     * @param enable
     * @return
     */
    Refreshable setEnableRefresh(boolean enable);



    /**
     * 设置是否启在下拉Header的同时下拉内容
     *
     * @param enable
     * @return
     */
    Refreshable setEnableHeaderTranslationContent(boolean enable);


    /**
     * 设置是否启在上拉Footer的同时上拉内容
     * @param enable
     * @return
     */
    Refreshable setEnableFooterTranslationContent(boolean enable);


    /**
     * 设置是否开启在刷新时候禁止操作内容视图
     *
     * @param disable
     * @return
     */
    Refreshable setDisableContentWhenRefresh(boolean disable);


    /**
     * 设置是否开启在加载时候禁止操作内容视图
     * @param disable
     * @return
     */
    Refreshable setDisableContentWhenLoading(boolean disable);


    /**
     *
     * 设置是否监听列表在滚动到底部时触发加载事件（默认true）
     * @param enable
     * @return
     */
    Refreshable setEnableAutoLoadmore(boolean enable);


    /**
     * 标记数据全部加载完成，将不能再次触发加载功能（true）
     * 在适当时候请使用 finishLoadmoreWithNoMoreData 和 resetNoMoreData 代替
     * @param finished
     * @return
     */

    Refreshable setLoadmoreFinished(boolean finished);


    /**
     *
     * 设置指定的Footer
     * @param footer
     * @return
     */
    Refreshable setRefreshFooter(RefreshFootable footer);

    /**
     *
     * 设置指定的Footer
     * @param footer
     * @param width
     * @param height
     * @return
     */
    Refreshable setRefreshFooter(RefreshFootable footer, int width, int height);


    /**
     *
     * 设置指定的Header
     * @param header
     * @return
     */
    Refreshable setRefreshHeader(RefreshHeadable header);

    /**
     *
     * 设置指定的Header
     * @param header
     * @param width
     * @param height
     * @return
     */
    Refreshable setRefreshHeader(RefreshHeadable header, int width, int height);


    /**
     *
     * 设置指定的Content
     * @param content
     * @return
     */
    Refreshable setRefreshContent(View content);



    /**
     *
     * 设置指定的Content
     * @param content
     * @param width
     * @param height
     * @return
     */
    Refreshable setRefreshContent(View content, int width, int height);



    /**
     *
     * 设置是否启用越界回弹
     * @param enable
     * @return
     */
    Refreshable setEnableOverScrollBounce(boolean enable);



    /**
     *
     * 设置是否开启纯滚动模式
     * @param enable
     * @return
     */
    Refreshable setEnablePureScrollMode(boolean enable);



    /**
     * 设置是否在加载更多完成之后滚动内容显示新数据
     * @param enable
     * @return
     */
    Refreshable setEnableScrollContentWhenLoaded(boolean enable);


    /**
     *
     * 是否在刷新完成之后滚动内容显示新数据
     * @param enable
     * @return
     */
    Refreshable setEnableScrollContentWhenRefreshed(boolean enable);



    /**
     *
     * 设置在内容不满一页的时候，是否可以上拉加载更多
     * @param enable
     * @return
     */
    Refreshable setEnableLoadmoreWhenContentNotFull(boolean enable);


    /**
     *
     * 设置是否启用越界拖动（仿苹果效果）
     * @param enable
     * @return
     */
    Refreshable setEnableOverScrollDrag(boolean enable);


    /**
     *
     * 设置是否在全部加载结束之后Footer跟随内容
     * @param enable
     * @return
     */
    Refreshable setEnableFooterFollowWhenLoadFinished(boolean enable);


    /**
     *
     * 设置是会否启用嵌套滚动功能（默认关闭+智能开启）
     * @param enabled
     * @return
     */
    Refreshable setEnableNestedScroll(boolean enabled);


    /**
     * 单独设置刷新监听器
     *
     * @param listener
     * @return
     */
    Refreshable setOnRefreshListener(OnRefreshListener listener);


    /**
     *
     * 单独设置加载监听器
     * @param listener
     * @return
     */
    Refreshable setOnLoadmoreListener(OnLoadmoreListener listener);


    /**
     *
     * 同时设置刷新和加载监听器
     * @param listener
     * @return
     */
    Refreshable setOnRefreshLoadmoreListener(OnRefreshLoadmoreListener listener);



    /**
     *
     * 设置多功能监听器
     * @param listener
     * @return
     */
    Refreshable setOnMultiPurposeListener(OnMultiPurposeListener listener);


    /**
     * 设置主题颜色
     *
     * @param primaryColorId
     * @return
     */
    Refreshable setPrimaryColorsId(@ColorRes int... primaryColorId);

    /**
     *
     * 设置主题颜色
     * @param colors
     * @return
     */
    Refreshable setPrimaryColors(int... colors);



    /**
     * 设置滚动边界判断器
     * @param boundary
     * @return
     */
    Refreshable setScrollBoundaryDecider(ScrollBoundaryDecider boundary);


    /**
     * 完成刷新
     * @return
     */
    Refreshable finishRefresh();


    /**
     * 完成加载
     *
     * @return
     */
    Refreshable finishLoadmore();


    /**
     * 完成刷新
     * @param delayed
     * @return
     */
    Refreshable finishRefresh(int delayed);


    /**
     * 完成加载
     * @param success 数据是否成功刷新 （会影响到上次更新时间的改变）
     * @return
     */
    Refreshable finishRefresh(boolean success);



    /**
     *
     * 完成刷新
     * @param delayed
     * @param success
     * @return
     */
    Refreshable finishRefresh(int delayed, boolean success);


    /**
     * 完成加载
     * @param delayed
     * @return
     */
    Refreshable finishLoadmore(int delayed);


    /**
     * 完成加载
     * @param success
     * @return
     */
    Refreshable finishLoadmore(boolean success);



    /**
     * 完成加载
     * @param delayed
     * @param success
     * @return
     */
    Refreshable finishLoadmore(int delayed, boolean success);



    /**
     * 完成加载
     *
     * @param delayed
     * @param success
     * @param noMoreData
     * @return
     */
    Refreshable finishLoadmore(int delayed, boolean success, boolean noMoreData);


    /**
     * 完成加载并标记没有更多数据
     *
     * @return
     */
    Refreshable finishLoadmoreWithNoMoreData();



    /**
     *
     * 恢复没有更多数据的原始状态
     * @return
     */
    Refreshable resetNoMoreData();


    /**
     * 获取当前 Header
     * @return
     */
    @Nullable
    RefreshHeadable getRefreshHeader();

    /**
     * 获取当前 Footer
     *
     * @return
     */
    @Nullable
    RefreshFootable getRefreshFooter();

    /**
     *
     * 获取当前状态
     * @return
     */
    RefreshState getState();


    /**
     *
     * 获取实体布局视图
     * @return
     */
    ViewGroup getLayout();


    /**
     * 是否正在刷新
     * @return
     */
    boolean isRefreshing();


    /**
     * 是否正在加载
     *
     * @return
     */
    boolean isLoading();

    /**
     * 自动刷新
     * @return
     */
    boolean autoRefresh();

    /**
     * 自动刷新
     * @param delayed 开始延时
     * @return
     */
    boolean autoRefresh(int delayed);

    /**
     * 自动刷新
     * @param delayed 开始延时
     * @param duration 拖拽动画持续时间
     * @param dragrate 拉拽的高度比率（要求 ≥ 1 ）
     * @return
     */

    boolean autoRefresh(int delayed, int duration, float dragrate);

    /**
     * 自动加载
     * @return
     */
    boolean autoLoadmore();

    /**
     * 自动加载
     * @param delayed 开始延时
     * @return
     */
    boolean autoLoadmore(int delayed);

    /**
     * 自动加载
     * @param delayed 开始延时
     * @param duration 拖拽动画持续时间
     * @param dragrate 拉拽的高度比率（要求 ≥ 1 ）
     * @return
     */
    boolean autoLoadmore(int delayed, int duration, float dragrate);

    /**
     *
     *  是否可以刷新
     * @return
     */
    boolean isEnableRefresh();

    /**
     * 是否可以加载更多
     * @return
     */

    boolean isEnableLoadmore();

    /**
     *
     * 是否加载完成
     * @return
     */
    boolean isLoadmoreFinished();

    /**
     * 是否可以自动加载
     * @return
     */

    boolean isEnableAutoLoadmore();

    /**
     *
     * 是否可以滚动边界
     * @return
     */

    boolean isEnableOverScrollBounce();

    /**
     *
     *是否启用纯滚动模式
     * @return
     */

    boolean isEnablePureScrollMode();

    /**
     *加载时启用滚动内容
     *
     * @return
     */

    boolean isEnableScrollContentWhenLoaded();
}
