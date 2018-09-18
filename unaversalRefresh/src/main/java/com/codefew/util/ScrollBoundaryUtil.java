package com.codefew.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/**
 * Created by flowing on 2018/2/9.
 * @version 1.0
 * @author wangwentao
 * 滚动边界工具类
 */

public class ScrollBoundaryUtil {



    /**
     *
     * 是否可以刷新
     * @param targetView
     * @param event
     * @return
     */
    public static boolean canRefresh(View targetView, MotionEvent event) {
        if (canScrollUp(targetView) && targetView.getVisibility() == View.VISIBLE) {
            return false;
        }
        //event == null 时 canRefresh 不会动态递归搜索
        if (targetView instanceof ViewGroup && event != null) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            final int childCount = viewGroup.getChildCount();
            PointF point = new PointF();
            for (int i = childCount; i > 0; i--) {
                View child = viewGroup.getChildAt(i - 1);
                if (isTransformedTouchPointInView(viewGroup, child, event.getX(), event.getY(), point)) {
                    event = MotionEvent.obtain(event);
                    event.offsetLocation(point.x, point.y);
                    return canRefresh(child, event);
                }
            }
        }
        return true;
    }

    /**
     *
     * 是否加载更多
     * @param targetView
     * @param event
     * @return
     */
    public static boolean canLoadmore(View targetView, MotionEvent event) {
        if (!canScrollDown(targetView) && canScrollUp(targetView) && targetView.getVisibility() == View.VISIBLE) {
            return true;
        }
        //event == null 时 canLoadmore 不会动态递归搜索
        if (targetView instanceof ViewGroup && event != null) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            final int childCount = viewGroup.getChildCount();
            PointF point = new PointF();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (isTransformedTouchPointInView(viewGroup, child, event.getX(), event.getY(), point)) {
                    event = MotionEvent.obtain(event);
                    event.offsetLocation(point.x, point.y);
                    return canLoadmore(child, event);
                }
            }
        }
        return false;
    }


    /**
     *
     * 是否可以向下滚动
     * @param targetView
     * @param event
     * @return
     */
    public static boolean canScrollDown(View targetView, MotionEvent event) {
        if (canScrollDown(targetView) && targetView.getVisibility() == View.VISIBLE) {
            return true;
        }
        //event == null 时 canScrollDown 不会动态递归搜索
        if (targetView instanceof ViewGroup && event != null) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            final int childCount = viewGroup.getChildCount();
            PointF point = new PointF();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (isTransformedTouchPointInView(viewGroup, child, event.getX(), event.getY(), point)) {
                    event = MotionEvent.obtain(event);
                    event.offsetLocation(point.x, point.y);
                    return canScrollDown(child, event);
                }
            }
        }
        return false;
    }


    /**
     * 是否可以向上滚动
     *
     * 处理listview
     * @param targetView
     * @return
     */

    public static boolean canScrollUp(View targetView) {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (targetView instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) targetView;
                return absListView.getChildCount() > 0
                        && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                        .getTop() < absListView.getPaddingTop());
            } else {
                return targetView.getScrollY() > 0;
            }
        } else {
            return targetView.canScrollVertically(-1);
        }
    }

    /**
     * 是否可以向下滚动
     * 处理listview
     * @param targetView
     * @return
     */
    public static boolean canScrollDown(View targetView) {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (targetView instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) targetView;
                return absListView.getChildCount() > 0
                        && (absListView.getLastVisiblePosition() < absListView.getChildCount() - 1
                        || absListView.getChildAt(absListView.getChildCount() - 1).getBottom() > absListView.getPaddingBottom());
            } else {
                return targetView.getScrollY() < 0;
            }
        } else {
            return targetView.canScrollVertically(1);
        }
    }



    /**
     *是否转换触摸点在view上
     *
     *
     * @param group
     * @param child
     * @param x
     * @param y
     * @param outLocalPoint
     * @return
     */

    public static boolean isTransformedTouchPointInView(ViewGroup group, View child, float x, float y,PointF outLocalPoint) {
        if (child.getVisibility() != View.VISIBLE) {
            return false;
        }
        final float[] point = new float[2];
        point[0] = x;
        point[1] = y;
        transformPointToViewLocal(group, child, point);
        final boolean isInView = pointInView(child, point[0], point[1], 0);
        if (isInView && outLocalPoint != null) {
            outLocalPoint.set(point[0]-x, point[1]-y);
        }
        return isInView;
    }


    /**
     *  是否在触摸点的view中
     *
     * @param view
     * @param localX
     * @param localY
     * @param slop
     * @return
     */
    public static boolean pointInView(View view, float localX, float localY, float slop) {
        final float left = /*Math.max(view.getPaddingLeft(), 0)*/ - slop;
        final float top = /*Math.max(view.getPaddingTop(), 0)*/ - slop;
        final float width = view.getWidth()/* - Math.max(view.getPaddingLeft(), 0) - Math.max(view.getPaddingRight(), 0)*/;
        final float height = view.getHeight()/* - Math.max(view.getPaddingTop(), 0) - Math.max(view.getPaddingBottom(), 0)*/;
        return localX >= left && localY >= top && localX < ((width) + slop) &&
                localY < ((height) + slop);
    }

    /**
     *转换点到本地
     *
     * @param group
     * @param child
     * @param point
     */
    public static void transformPointToViewLocal(ViewGroup group, View child, float[] point) {
        point[0] += group.getScrollX() - child.getLeft();
        point[1] += group.getScrollY() - child.getTop();
    }
}
