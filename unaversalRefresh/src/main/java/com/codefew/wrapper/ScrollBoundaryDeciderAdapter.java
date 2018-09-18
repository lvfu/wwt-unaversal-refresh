package com.codefew.wrapper;

import android.view.MotionEvent;
import android.view.View;

import com.codefew.api.ScrollBoundaryDecider;
import com.codefew.util.ScrollBoundaryUtil;

/**
 * Created by flowing on 2018/2/9.
 * @version 1.0
 * @author wangwentao
 *
 * 边界
 */

public class ScrollBoundaryDeciderAdapter implements ScrollBoundaryDecider {

    //<editor-fold desc="Internal">
    protected MotionEvent mActionEvent;
    protected ScrollBoundaryDecider boundary;
    protected boolean mEnableLoadmoreWhenContentNotFull;

    void setScrollBoundaryDecider(ScrollBoundaryDecider boundary){
        this.boundary = boundary;
    }

    void setActionEvent(MotionEvent event) {
        //event 在没有必要时候会被设置为 null
        mActionEvent = event;
    }
    //</editor-fold>

    //<editor-fold desc="ScrollBoundaryDecider">
    @Override
    public boolean canRefresh(View content) {
        if (boundary != null) {
            return boundary.canRefresh(content);
        }
        //mActionEvent == null 时 canRefresh 不会动态递归搜索
        return ScrollBoundaryUtil.canRefresh(content, mActionEvent);
    }

    @Override
    public boolean canLoadmore(View content) {
        if (boundary != null) {
            return boundary.canLoadmore(content);
        }
        if (mEnableLoadmoreWhenContentNotFull) {
            //mActionEvent == null 时 canScrollDown 不会动态递归搜索
            return !ScrollBoundaryUtil.canScrollDown(content, mActionEvent);
        }
        //mActionEvent == null 时 canLoadmore 不会动态递归搜索
        return ScrollBoundaryUtil.canLoadmore(content, mActionEvent);
    }

    public void setEnableLoadmoreWhenContentNotFull(boolean enable) {
        mEnableLoadmoreWhenContentNotFull = enable;
    }
    //</editor-fold>
}
