package com.codefew.listener;

import com.codefew.api.RefreshFootable;
import com.codefew.api.Refreshable;
import com.codefew.status.RefreshState;

/**
 * Created by flowing on 2018/2/7.
 * @author wangwentao
 * @version 1.0
 * 状态监听器
 */

public interface OnStateChangedListener {

    /**
     * 状态改变事件 {@link RefreshState}
     * @param refreshable
     * @param oldState 改变之前的状态
     * @param newState 改变之后的状态
     * @throws Exception
     */
    void onStateChanged(Refreshable refreshable, RefreshState oldState, RefreshState newState) throws Exception;
}
