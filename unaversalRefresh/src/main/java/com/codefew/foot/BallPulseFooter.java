package com.codefew.foot;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.codefew.R;
import com.codefew.api.RefreshFootable;
import com.codefew.api.RefreshKernel;
import com.codefew.api.Refreshable;
import com.codefew.status.RefreshState;
import com.codefew.status.RefreshStyle;
import com.codefew.util.DensityUtil;

import static android.view.View.MeasureSpec.AT_MOST;
import static android.view.View.MeasureSpec.getSize;
import static android.view.View.MeasureSpec.makeMeasureSpec;
import static android.widget.ListPopupWindow.WRAP_CONTENT;


/**
 * Created by flowing on 2018/2/8.
 * @author wangwentao
 * @version 1.0
 * 球形脉冲footer
 */

public class BallPulseFooter extends ViewGroup implements RefreshFootable {



    private BallPulseView mBallPulseView;
    private RefreshStyle mRefreshStyle = RefreshStyle.Translate;

    //<editor-fold desc="ViewGroup">
    public BallPulseFooter(@NonNull Context context) {
        super(context);
        initView(context, null, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        mBallPulseView = new BallPulseView(context);
        addView(mBallPulseView, WRAP_CONTENT, WRAP_CONTENT);
        setMinimumHeight(DensityUtil.dp2px(60));

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BallPulseFooter);

        int primaryColor = ta.getColor(R.styleable.BallPulseFooter_srlPrimaryColor, 0);
        int accentColor = ta.getColor(R.styleable.BallPulseFooter_srlAccentColor, 0);
        if (primaryColor != 0) {
            mBallPulseView.setNormalColor(primaryColor);
        }
        if (accentColor != 0) {
            mBallPulseView.setAnimatingColor(accentColor);
        }

        mRefreshStyle = RefreshStyle.values()[ta.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle,
                mRefreshStyle.ordinal())];

        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpec = makeMeasureSpec(getSize(widthMeasureSpec), AT_MOST);
        int heightSpec = makeMeasureSpec(getSize(heightMeasureSpec), AT_MOST);
        mBallPulseView.measure(widthSpec, heightSpec);
        setMeasuredDimension(
                resolveSize(mBallPulseView.getMeasuredWidth(), widthMeasureSpec),
                resolveSize(mBallPulseView.getMeasuredHeight(), heightMeasureSpec)
        );
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int pwidth = getMeasuredWidth();
        int pheight = getMeasuredHeight();
        int cwidth = mBallPulseView.getMeasuredWidth();
        int cheight = mBallPulseView.getMeasuredHeight();
        int left = pwidth / 2 - cwidth / 2;
        int top = pheight / 2 - cheight / 2;
        mBallPulseView.layout(left, top, left + cwidth, top + cheight);
    }
    //</editor-fold>

    //<editor-fold desc="RefreshFooter">
    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {
    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {
    }

    @Override
    public void onLoadmoreReleased(Refreshable layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull Refreshable layout, int footerHeight, int extendHeight) {
        mBallPulseView.startAnim();
    }



    @Override
    public int onFinish(@NonNull Refreshable layout, boolean success) {
        mBallPulseView.stopAnim();
        return 0;
    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }

    @Override@Deprecated
    public void setPrimaryColors(@ColorInt int... colors) {
        if (colors.length > 1) {
            mBallPulseView.setNormalColor(colors[1]);
            mBallPulseView.setAnimatingColor(colors[0]);
        } else if (colors.length > 0) {
            mBallPulseView.setNormalColor(ColorUtils.compositeColors(0x99ffffff,colors[0]));
            mBallPulseView.setAnimatingColor(colors[0]);
        }
    }
    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public RefreshStyle getRefreshStyle() {
        return mRefreshStyle;
    }


    //<editor-fold desc="API">
    public BallPulseFooter setSpinnerStyle(RefreshStyle refreshStyle) {
        this.mRefreshStyle = refreshStyle;
        return this;
    }

    public BallPulseFooter setIndicatorColor(@ColorInt int color) {
        mBallPulseView.setIndicatorColor(color);
        return this;
    }

    public BallPulseFooter setNormalColor(@ColorInt int color) {
        mBallPulseView.setNormalColor(color);
        return this;
    }

    public BallPulseFooter setAnimatingColor(@ColorInt int color) {
        mBallPulseView.setAnimatingColor(color);
        return this;
    }




    @Override
    public void onStateChanged(Refreshable refreshable, RefreshState oldState, RefreshState newState) throws Exception {

    }
}
