package com.codefew.status;

/**
 * Created by flowing on 2018/2/6.1.
 * @author wangwentao
 * @version 1.0
 * 刷新所有舍得状态
 */

public enum RefreshState {

    /**
     * 初始化状态
     * 角色为0，所有都为false
     */
    None(0,false),
    /**
     * 下拉刷新
     * 角色为1，拖动中为true
     */
    PullDownToRefresh(1,true),
    /**
     *上拉加载
     * 角色为2，拖动中true
     */
    PullToUpLoad(2,true),
    /**
     *下拉取消
     * 角色为1，拖动为false
     */
    PullDownCanceled(1,false),
    /**
     *
     * 上拉取消
     * 角色为2 ，拖动为false
     */
    PullUpCanceled(2,false),
    /**
     *下拉释放
     * 角色为1，拖动为true
     */
    ReleaseToRefresh(1,true),
    /**
     *
     * 加载释放
     * 角色为2，拖动为true
     */
    ReleaseToLoad(2,true),
    /**
     *
     * 组合释放中
     * 角色是1，拖动是true
     */
    ReleaseToTwoLevel(1, true),
    /**
     *
     * 组合释放后
     * 角色是1，拖动是false
     */
    TwoLevelReleased(1,false),
    /**
     *
     * 刷新释放后
     * 角色为1，拖动是false
     */
    RefreshReleased(1,false),
    /**
     *
     *
     * 加载结束后
     * 角色为2 ，拖动为false
     */
    LoadReleased(2,false),
    /**
     *
     *刷新中
     * 角色为1，拖动为false， 刷新状态是true
     *
     */
    Refreshing(1,false,true),
    /**
     *
     * 加载中
     * 角色为2，拖动是false，刷新状态是true
     */
    Loading(2,false,true),
    /**
     *
     * 组合状态中
     * 角色是1，拖动是false，刷新状态是true
     */
    TwoLevel(1, false, true),
    /**
     *
     * 刷新结束
     * 角色是1， 拖动是false，刷新状态是false，完成状态是true
     */
    RefreshFinish(1,false,false,true),
    /**
     *
     * 加载结束
     * 角色是2， 拖动是false，刷新状态是false，完成状态是true
     */
    LoadFinish(2,false,false,true),
    /**
     * 组合结束
     * 角色是1， 拖动是false，刷新状态是false，完成状态是true
     *
     */
    TwoLevelFinish(1,false,false,true),;

    /**
     *  角色
     */

    private final int role;
    /**
     * 正在拖动状态：PullDownToRefresh PullToUpLoad ReleaseToRefresh ReleaseToLoad ReleaseToTwoLevel
     */
    public final boolean dragging;
    /**
     * 正在刷新状态：Refreshing Loading TwoLevel
     */
    public final boolean opening;

    /**
     * 正在完成状态：RefreshFinish LoadFinish TwoLevelFinish
     */
    public final boolean finishing;

    /**
     *
     * 过程中的状态
     * @param role
     * @param draging
     */

    RefreshState(int role, boolean draging) {
        this.role = role;
        this.dragging = draging;
        this.opening = false;
        this.finishing = false;
    }

    /**
     *
     * 正在进行的状态
     * @param role
     * @param dragging
     * @param opening
     */
    RefreshState(int role, boolean dragging, boolean opening) {
        this.role = role;
        this.dragging = dragging;
        this.opening = opening;
        this.finishing = false;
    }

    /**
     *
     * 结束的状态
     * @param role
     * @param dragging
     * @param opening
     * @param finishing
     */
    RefreshState(int role, boolean dragging, boolean opening, boolean finishing) {
        this.role = role;
        this.dragging = dragging;
        this.opening = opening;
        this.finishing = finishing;
    }

    /**
     * header的角色是1
     *
     * @return
     */
    public boolean isHeader() {
        return role == 1;
    }

    /**
     *
     * footer的角色是2
     * @return
     */
    public boolean isFooter() {
        return role == 2;
    }
}
