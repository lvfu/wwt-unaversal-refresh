package com.codefew.listener;

/**
 * Created by flowing on 2018/2/7.
 * @version 1.0
 * @author wangwentao
 * 动画监听器
 */

public interface OnAnimationListener {

    /**
     *
     * 动画开始
     * @throws Exception
     */
    void onAnimationStart() throws Exception;


    /**
     * 动画结束
     * @throws Exception
     */
    void OnAnimationEnd() throws Exception;

    /**
     *
     * 动画进行中
     * @throws Exception
     */
    void OnAnimationProcessing() throws Exception;
}
