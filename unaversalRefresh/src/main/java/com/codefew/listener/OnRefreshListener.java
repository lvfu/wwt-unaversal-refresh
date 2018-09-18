package com.codefew.listener;

import com.codefew.api.Refreshable;

/**
 * Created by flowing on 2018/2/6.
 * @author wagwentao
 * @version 1.0
 * 下拉刷新监听器
 */

public interface OnRefreshListener {

    /**
     *
     * 下拉刷新
     * @param refreshable
     * @throws Exception
     */

    void onRefresh(Refreshable refreshable) throws Exception;
}
