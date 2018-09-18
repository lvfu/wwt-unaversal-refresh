package com.codefew.listener;

import com.codefew.api.RefreshFootable;
import com.codefew.api.RefreshHeadable;

/**
 * Created by flowing on 2018/2/6
 * @version 1.0
 * @author wangwentao
 * 多功能监听器的接口
 */

public interface OnMultiPurposeListener extends OnRefreshLoadmoreListener, OnStateChangedListener{


    /**
     *
     *头部刷新中
     *
     * @param header
     * @param percent
     * @param offset
     * @param headerHeight
     * @param extendHeight
     * @throws Exception
     *
     */


    void onHeaderPulling(RefreshHeadable header, float percent, int offset, int headerHeight, int extendHeight)throws Exception;

    /**
     *
     * 头部松开后
     * @param header
     * @param headerHeight
     * @param extendHeight
     * @throws Exception
     */
    void onHeaderReleased(RefreshHeadable header, int headerHeight, int extendHeight) throws Exception;

    /**
     *
     *头部松开中
     * @param header
     * @param percent
     * @param offset
     * @param headerHeight
     * @param extendHeight
     * @throws Exception
     */
    void onHeaderReleasing(RefreshHeadable header, float percent, int offset, int headerHeight, int extendHeight) throws Exception;

    /**
     *
     *下拉动画开始
     * @param header
     * @param headerHeight
     * @param extendHeight
     * @throws Exception
     */
    void onHeaderStartAnimator(RefreshHeadable header, int headerHeight, int extendHeight) throws Exception;

    /**
     *下拉完成后
     * @param header
     * @param success
     * @throws Exception
     */
    void onHeaderFinish(RefreshHeadable header, boolean success) throws Exception;


    /**
     *加载过程中
     *
     * @param footer
     * @param percent
     * @param offset
     * @param footerHeight
     * @param extendHeight
     * @throws Exception
     */
    void onFooterPulling(RefreshFootable footer, float percent, int offset, int footerHeight, int extendHeight)throws Exception;

    /**
     *
     * 加载完成后
     * @param footer
     * @param footerHeight
     * @param extendHeight
     * @throws  Exception
     */
    void onFooterReleased(RefreshFootable footer, int footerHeight, int extendHeight) throws Exception;

    /**
     * 加载释放中
     *
     * @param footer
     * @param percent
     * @param offset
     * @param footerHeight
     * @param extendHeight
     * @throws Exception
     */
    void onFooterReleasing(RefreshFootable footer, float percent, int offset, int footerHeight, int extendHeight)throws Exception;

    /**
     *
     *  footer开始动画
     * @param footer
     * @param footerHeight
     * @param extendHeight
     * @throws Exception
     */
    void onFooterStartAnimator(RefreshFootable footer, int footerHeight, int extendHeight) throws  Exception;

    /**
     *footer完成
     * @param footer
     * @param success
     * @throws Exception
     */
    void onFooterFinish(RefreshFootable footer, boolean success)throws Exception;
}
