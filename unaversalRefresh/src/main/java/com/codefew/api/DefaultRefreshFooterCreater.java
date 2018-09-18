package com.codefew.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by flowing on 2018/2/7.
 * @version 1.0
 * @author wangwentao
 * footer 默认创建器
 */

public interface DefaultRefreshFooterCreater {

    /**
     * 创建器
     * @param context
     * @param layout
     * @return
     */
    @NonNull
    RefreshFootable createRefreshFooter(Context context, Refreshable layout);
}
