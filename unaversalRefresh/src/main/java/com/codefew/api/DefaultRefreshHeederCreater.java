package com.codefew.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by flowing on 2018/2/7.
 * @version 1.0
 * @author wangwentao
 * 默认footer创建器
 */

public interface DefaultRefreshHeederCreater {


    /**
     * 创建器
     * @param context
     * @param layout
     * @return
     */
    @NonNull
    RefreshHeadable createRefreshHeader(Context context, Refreshable layout);
}
