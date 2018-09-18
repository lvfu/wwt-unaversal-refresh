package com.codefew.api;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.codefew.listener.OnStateChangedListener;
import com.codefew.status.RefreshState;
import com.codefew.status.RefreshStyle;

/**
 * Created by flowing on 2018/2/7.
 * @version 1.0
 * @author wangwentao
 * 刷新内部状态接口
 */

public interface RefreshInternalStutasable extends OnStateChangedListener{


    /**
     * 获取实体视图
     * @return
     */
    @NonNull
    View getView();

    /**
     * 获取变换方式 {@link RefreshStyle} 必须返回 非空
     * @return
     */
    @NonNull
    RefreshStyle getRefreshStyle();

    /**
     * 设置主题颜色
     * @param colors 对应Xml中配置的 srlPrimaryColor srlAccentColor
     */
    void setPrimaryColors(@ColorInt int... colors);

    /**
     * 尺寸定义完成 （如果高度不改变（代码修改：setHeader），只调用一次, 在RefreshLayout#onMeasure中调用）
     * @param kernel RefreshKernel
     * @param height HeaderHeight or FooterHeight
     * @param extendHeight extendHeaderHeight or extendFooterHeight
     */
    void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight);

    /**
     * 水平方向的拖动
     * @param percentX 下拉时，手指水平坐标对屏幕的占比（0 - percentX - 1）
     * @param offsetX 下拉时，手指水平坐标对屏幕的偏移（0 - offsetX - LayoutWidth）
     */
    void onHorizontalDrag(float percentX, int offsetX, int offsetMax);

    /**
     * 开始动画
     * @param layout RefreshLayout
     * @param height HeaderHeight or FooterHeight
     * @param extendHeight extendHeaderHeight or extendFooterHeight
     */
    void onStartAnimator(@NonNull Refreshable layout, int height, int extendHeight);

    /**
     * 动画结束
     * @param layout RefreshLayout
     * @param success 数据是否成功刷新或加载
     * @return 完成动画所需时间 如果返回 Integer.MAX_VALUE 将取消本次完成事件，继续保持原有状态
     */
    int onFinish(@NonNull Refreshable layout, boolean success);

    /**
     * 是否支持水平方向的拖动（将会影响到onHorizontalDrag的调用）
     * @return 水平拖动需要消耗更多的时间和资源，所以如果不支持请返回false
     */
    boolean isSupportHorizontalDrag();

}
