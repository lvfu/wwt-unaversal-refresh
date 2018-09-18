package com.codefew.wrapper;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.codefew.UnaversalRefreshLayout;
import com.codefew.api.RefreshFootable;
import com.codefew.api.RefreshHeadable;
import com.codefew.api.RefreshKernel;
import com.codefew.api.Refreshable;
import com.codefew.status.RefreshState;
import com.codefew.status.RefreshStyle;

/**
 * Created by flowing on 2018/2/9.
 * @version 1.0
 * @author wangwentao
 * 头部的包装类
 */

public class RefreshHeaderWrapper implements RefreshHeadable{


    private View mWrapperView;
    private RefreshStyle mRefreshStyle;

    public RefreshHeaderWrapper(View wrapper) {
        this.mWrapperView = wrapper;
    }

    @NonNull
    public View getView() {
        return mWrapperView;
    }

    @Override
    public int onFinish(@NonNull Refreshable layout, boolean success) {
        return 0;
    }

    @Override@Deprecated
    public void setPrimaryColors(@ColorInt int ... colors) {

    }

    @NonNull
    @Override
    public RefreshStyle getRefreshStyle() {
        if (mRefreshStyle != null) {
            return mRefreshStyle;
        }
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof UnaversalRefreshLayout.LayoutParams) {
            mRefreshStyle = ((UnaversalRefreshLayout.LayoutParams) params).spinnerStyle;
            if (mRefreshStyle != null) {
                return mRefreshStyle;
            }
        }
        if (params != null) {
            if (params.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                return mRefreshStyle = RefreshStyle.Scale;
            }
        }
        return mRefreshStyle = RefreshStyle.Translate;
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof UnaversalRefreshLayout.LayoutParams) {
            kernel.requestDrawBackgoundForHeader(((UnaversalRefreshLayout.LayoutParams) params).backgroundColor);
        }
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onPullingDown(float percent, int offset, int headHeight, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headHeight, int extendHeight) {

    }

    @Override
    public void onRefreshReleased(Refreshable layout, int headerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull Refreshable layout, int headHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(Refreshable refreshLayout, RefreshState oldState, RefreshState newState) {

    }
}
