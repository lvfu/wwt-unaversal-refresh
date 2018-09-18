package com.codefew.head;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import com.codefew.R;
import com.codefew.api.RefreshFootable;
import com.codefew.api.RefreshHeadable;
import com.codefew.api.RefreshKernel;
import com.codefew.api.Refreshable;
import com.codefew.status.RefreshState;
import com.codefew.status.RefreshStyle;
import com.codefew.util.DensityUtil;
import com.codefew.view.RippleView;
import com.codefew.view.RoundDotView;
import com.codefew.view.RoundProgressView;
import com.codefew.view.WaveView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by flowing on 2018/2/8.
 * @author wangwentao
 * @version 1.0
 * 贝贝塞尔曲线类雷达风格刷新组件
 */

public class BezierRadarHeader  extends FrameLayout implements RefreshHeadable {

    private WaveView mWaveView;
    private RippleView mRippleView;
    private RoundDotView mDotView;
    private RoundProgressView mProgressView;
    private boolean mEnableHorizontalDrag = false;
    private boolean mIsRunning;

    //<editor-fold desc="FrameLayout">
    public BezierRadarHeader(Context context) {
        this(context,null);
    }

    public BezierRadarHeader(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BezierRadarHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        setMinimumHeight(DensityUtil.dp2px(100));
        /**
         * 初始化headView
         */
        mWaveView = new WaveView(getContext());
        mRippleView = new RippleView(getContext());
        mDotView = new RoundDotView(getContext());
        mProgressView = new RoundProgressView(getContext());
        if (isInEditMode()) {
            this.addView(mWaveView, MATCH_PARENT, MATCH_PARENT);
            this.addView(mProgressView, MATCH_PARENT, MATCH_PARENT);
            mWaveView.setHeadHeight(1000);
        } else {
            this.addView(mWaveView, MATCH_PARENT, MATCH_PARENT);
            this.addView(mDotView, MATCH_PARENT, MATCH_PARENT);
            this.addView(mProgressView, MATCH_PARENT, MATCH_PARENT);
            this.addView(mRippleView, MATCH_PARENT, MATCH_PARENT);
            mProgressView.setScaleX(0);
            mProgressView.setScaleY(0);
        }


        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BezierRadarHeader);

        mEnableHorizontalDrag = ta.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, mEnableHorizontalDrag);
        int primaryColor = ta.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, 0);
        int accentColor = ta.getColor(R.styleable.BezierRadarHeader_srlAccentColor, 0);
        if (primaryColor != 0) {
            setPrimaryColor(primaryColor);
        }
        if (accentColor != 0) {
            setAccentColor(accentColor);
        }

        ta.recycle();
    }

    //</editor-fold>

    //<editor-fold desc="API">
    public BezierRadarHeader setPrimaryColor(@ColorInt int color) {
        mWaveView.setWaveColor(color);
        mProgressView.setBackColor(color);
        return this;
    }

    public BezierRadarHeader setAccentColor(@ColorInt int color) {
        mDotView.setDotColor(color);
        mRippleView.setFrontColor(color);
        mProgressView.setFrontColor(color);
        return this;
    }

    public BezierRadarHeader setPrimaryColorId(@ColorRes int colorId) {
        setPrimaryColor(ContextCompat.getColor(getContext(), colorId));
        return this;
    }

    public BezierRadarHeader setAccentColorId(@ColorRes int colorId) {
        setAccentColor(ContextCompat.getColor(getContext(), colorId));
        return this;
    }

    public BezierRadarHeader setEnableHorizontalDrag(boolean enable) {
        this.mEnableHorizontalDrag = enable;
        if (!enable) {
            mWaveView.setWaveOffsetX(-1);
        }
        return this;
    }

    //</editor-fold>

    //<editor-fold desc="RefreshHeader">
    @Override@Deprecated
    public void setPrimaryColors(@ColorInt int ... colors) {
        if (colors.length > 0) {
            setPrimaryColor(colors[0]);
        }
        if (colors.length > 1) {
            setAccentColor(colors[1]);
        }
    }

    @NonNull
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public RefreshStyle getRefreshStyle() {
        return RefreshStyle.Scale;
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return mEnableHorizontalDrag;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        mWaveView.setWaveOffsetX(offsetX);
        mWaveView.invalidate();
    }

    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {
        mWaveView.setHeadHeight(Math.min(headerHeight, offset));
        mWaveView.setWaveHeight((int)(1.9f*Math.max(0, offset - headerHeight)));
        mDotView.setFraction(percent);
        if (mIsRunning) {
            mWaveView.invalidate();
        }
    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {
        onPullingDown(percent, offset, headerHeight, extendHeight);
    }

    @Override
    public void onRefreshReleased(final Refreshable layout, int headerHeight, int extendHeight) {
        mIsRunning = true;
        mWaveView.setHeadHeight(headerHeight);
        ValueAnimator animator = ValueAnimator.ofInt(
                mWaveView.getWaveHeight(), 0,
                -(int)(mWaveView.getWaveHeight()*0.8),0,
                -(int)(mWaveView.getWaveHeight()*0.4f),0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mWaveView.setWaveHeight((int) animation.getAnimatedValue()/2);
                mWaveView.invalidate();
            }
        });
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(800);
        animator.start();
        /*处理圈圈进度条**/
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mDotView.setVisibility(INVISIBLE);
                mProgressView.animate().scaleX((float) 1.0);
                mProgressView.animate().scaleY((float) 1.0);
                layout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mProgressView.startAnim();
                    }
                }, 200);
            }
        });

        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDotView.setAlpha((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }

    @Override
    public void onStateChanged(Refreshable refreshLayout, RefreshState oldState, RefreshState newState) throws Exception {
        switch (newState) {
            case None:
                mRippleView.setVisibility(GONE);
                mDotView.setAlpha(1);
                mDotView.setVisibility(VISIBLE);
                break;
            case PullDownToRefresh:
                mProgressView.setScaleX(0);
                mProgressView.setScaleY(0);
                break;
            case PullToUpLoad:
                break;
            case Refreshing:
                break;
            case Loading:
                break;
        }
    }

    @Override
    public void onStartAnimator(@NonNull Refreshable layout, int headerHeight, int extendHeight) {

    }

    @Override
    public int onFinish(@NonNull Refreshable layout, boolean success) {
        mProgressView.stopAnim();
        mProgressView.animate().scaleX(0f);
        mProgressView.animate().scaleY(0f);
        mRippleView.setVisibility(VISIBLE);
        mRippleView.startReveal();
        return 400;
    }


    //</editor-fold>
}