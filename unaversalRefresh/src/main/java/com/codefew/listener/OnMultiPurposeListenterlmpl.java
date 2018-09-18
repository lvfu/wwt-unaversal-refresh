package com.codefew.listener;

import com.codefew.api.RefreshFootable;
import com.codefew.api.RefreshHeadable;
import com.codefew.api.Refreshable;
import com.codefew.status.RefreshState;

/**
 * Created by flowing on 2018/2/7.
 * @version 1.0
 * @author wangwentao
 * 多功能监听器实现类
 */

public class OnMultiPurposeListenterlmpl implements OnMultiPurposeListener {
    @Override
    public void onRefresh(Refreshable refreshable) {

    }



    @Override
    public void onHeaderPulling(RefreshHeadable header, float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onHeaderReleased(RefreshHeadable header, int headerHeight, int extendHeight) {

    }

    @Override
    public void onHeaderReleasing(RefreshHeadable header, float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onHeaderStartAnimator(RefreshHeadable header, int headerHeight, int extendHeight) {

    }

    @Override
    public void onHeaderFinish(RefreshHeadable header, boolean success) {

    }

    @Override
    public void onFooterPulling(RefreshFootable footer, float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onFooterReleased(RefreshFootable footer, int footerHeight, int extendHeight) {

    }

    @Override
    public void onFooterReleasing(RefreshFootable footer, float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onFooterStartAnimator(RefreshFootable footer, int footerHeight, int extendHeight) {

    }

    @Override
    public void onFooterFinish(RefreshFootable footer, boolean success) {

    }

    @Override
    public void onStateChanged(Refreshable refreshable, RefreshState oldState, RefreshState newState) throws Exception {

    }

    @Override
    public void onLoadMore(Refreshable refreshable) throws Exception {

    }
}
