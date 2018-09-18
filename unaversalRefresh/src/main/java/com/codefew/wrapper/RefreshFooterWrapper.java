package com.codefew.wrapper;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.codefew.UnaversalRefreshLayout;
import com.codefew.api.RefreshFootable;
import com.codefew.api.RefreshKernel;
import com.codefew.api.Refreshable;
import com.codefew.status.RefreshState;
import com.codefew.status.RefreshStyle;

/**
 * Created by flowing on 2018/2/9.
 * @version 1.0
 * @author wangwentao
 * footer的包装类
 */

public class RefreshFooterWrapper implements RefreshFootable{

    private View mWrapperView;
    private RefreshStyle mRefreshStyle;

    public RefreshFooterWrapper(View wrapper) {
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
            if (params.height == 0) {
                return mRefreshStyle = RefreshStyle.Scale;
            }
        }
        return mRefreshStyle = RefreshStyle.Translate;
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof UnaversalRefreshLayout.LayoutParams) {
            kernel.requestDrawBackgoundForFooter(((UnaversalRefreshLayout.LayoutParams) params).backgroundColor);
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
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onLoadmoreReleased(Refreshable layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull Refreshable layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(Refreshable refreshLayout, RefreshState oldState, RefreshState newState) {

    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }
}
