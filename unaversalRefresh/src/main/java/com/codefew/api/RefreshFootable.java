package com.codefew.api;

/**
 * Created by flowing on 2018/2/6.
 *
 * @author wangwentao
 * @version 1.0
 * 针对foot的接口
 */

public interface RefreshFootable extends RefreshInternalStutasable {

    /**
     * 手指拖动下拉（会连续多次调用）
     * @param percent 下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+extendHeight) / footerHeight )
     * @param offset 下拉的像素偏移量  0 - offset - (footerHeight+extendHeight)
     * @param footerHeight Footer的高度
     * @param extendHeight Footer的扩展高度
     *
     */
    void onPullingUp(float percent, int offset, int footerHeight, int extendHeight);
    /**
     * 手指释放之后的持续动画（会连续多次调用）
     * @param percent 下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+extendHeight) / footerHeight )
     * @param offset 下拉的像素偏移量  0 - offset - (footerHeight+extendHeight)
     * @param footerHeight Footer的高度
     * @param extendHeight Footer的扩展高度
     */
    void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight);

    /**
     * 释放时刻（调用一次，将会触发加载）
     * @param layout RefreshLayout
     * @param footerHeight FooterHeight
     * @param extendHeight extendHeaderHeight or extendFooterHeight
     */
    void onLoadmoreReleased(Refreshable layout, int footerHeight, int extendHeight);


    /**
     * 设置数据全部加载完成，将不能再次触发加载功能
     * @param finished true 支持全部加载完成的状态显示 false 不支持
     * @return
     */
    boolean setLoadmoreFinished(boolean finished);
}
