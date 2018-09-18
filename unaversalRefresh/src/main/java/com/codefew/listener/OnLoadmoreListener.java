package com.codefew.listener;

import com.codefew.api.Refreshable;

/**
 * Created by flowing on 2018/2/6.
 * @version 1.0
 * @author wangwentao
 * 加载更多监听器
 */

public interface OnLoadmoreListener {


    /**
     *
     *  加载更多
     * @param refreshable
     * @throws Exception
     */
    void onLoadMore(Refreshable refreshable) throws Exception;
}
