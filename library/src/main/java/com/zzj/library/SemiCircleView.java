package com.zzj.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by J。 on 2016/5/19.
 * 半圆环进度条View
 */
public class SemiCircleView extends View implements Runnable {
    private int mWidth, mHeight;
    private TypedArray typedArray;
    //画笔
    private Paint mPaint, mTextPaint;
    //圆环背景色
    private int mCircleBackground;
    //圆环进度条颜色
    private int mProgressColor;
    //进度条百分比
    private float mProgressValue;
    //圆环宽度
    private float mRingWidth;
    private RectF mRectF;
    //开始角度
    private float mStartAngle;
    //扫过的角度
    private float mSweepAngle;
    //上，中，下文本
    private String mTopText, mCenterText, mBottomText;
    //上，中，下文本颜色
    private int mTopTextColor, mCenterTextColor, mBottomTextColor;
    //上，中，下文本大小
    private float mTopTextSize, mCenterTextSize, mBottomTextSize;

    public SemiCircleView(Context context) {
        this(context, null);
    }

    public SemiCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SemiCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.SemiCircleView);
        mCircleBackground = typedArray.getColor(R.styleable.SemiCircleView_circleBackground, context.getResources().getColor(R.color.circleBackgroundDefault));
        //获得圆环宽度大小，默认为20
        mRingWidth = typedArray.getDimension(R.styleable.SemiCircleView_ringWidth, 20.0f);
        //获得开始角度，默认为135
        mStartAngle = typedArray.getInteger(R.styleable.SemiCircleView_startAngle, 135);
        //获得扫过角度，默认为270
        mSweepAngle = typedArray.getInteger(R.styleable.SemiCircleView_sweepAngle, 270);
        //获得进度条颜色
        mProgressColor = typedArray.getColor(R.styleable.SemiCircleView_progressColor, context.getResources().getColor(R.color.progressColorDefault));
        //获得进度条进度，默认为25
        mProgressValue = typedArray.getInteger(R.styleable.SemiCircleView_progressValue, 25);
        //判断是否超过最大值
        mProgressValue = mProgressValue > 100 ? 100 : mProgressValue;
        //判断是否超过最小值
        mProgressValue = mProgressValue < 0 ? 0 : mProgressValue;
        mTopText = typedArray.getString(R.styleable.SemiCircleView_topText);
        mCenterText = typedArray.getString(R.styleable.SemiCircleView_centerText);
        mBottomText = typedArray.getString(R.styleable.SemiCircleView_bottomText);
        mTopTextColor = typedArray.getColor(R.styleable.SemiCircleView_topTextColor, Color.GRAY);
        mCenterTextColor = typedArray.getColor(R.styleable.SemiCircleView_centerTextColor, mProgressColor);
        mBottomTextColor = typedArray.getColor(R.styleable.SemiCircleView_bottomTextColor, Color.GRAY);
        mTopTextSize = typedArray.getDimension(R.styleable.SemiCircleView_topTextSize, 20);
        mCenterTextSize = typedArray.getDimension(R.styleable.SemiCircleView_centerTextSize, 72);
        mBottomTextSize = typedArray.getDimension(R.styleable.SemiCircleView_bottomTextSize, 20);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = mHeight = getMeasuredWidth() > getMeasuredHeight() ? getMeasuredHeight() : getMeasuredWidth();
        mPaint.setColor(mCircleBackground);
        mPaint.setStrokeWidth(mRingWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mRectF = new RectF(0 + mHeight / 10, 0 + mWidth / 10, mHeight - mHeight / 10, mWidth - mWidth / 10);
        canvas.drawArc(mRectF, mStartAngle, mSweepAngle, false, mPaint);
        mPaint.setColor(mProgressColor);
        canvas.drawArc(mRectF, mStartAngle, mSweepAngle / 100.0f * mProgressValue, false, mPaint);
        if (!TextUtils.isEmpty(mTopText)) {
            mTextPaint.setColor(mTopTextColor);
            mTextPaint.setTextSize(mTopTextSize);
            canvas.drawText(mTopText, mWidth / 2, mHeight / 2 - mHeight / 10, mTextPaint);
        }
        if (!TextUtils.isEmpty(mCenterText)) {
            mTextPaint.setColor(mCenterTextColor);
            mTextPaint.setTextSize(mCenterTextSize);
            canvas.drawText(mCenterText, mWidth / 2, mHeight / 2, mTextPaint);
        }
        if (!TextUtils.isEmpty(mBottomText)) {
            mTextPaint.setColor(mBottomTextColor);
            mTextPaint.setTextSize(mBottomTextSize);
            canvas.drawText(mBottomText, mWidth / 2, mHeight / 2 + mHeight / 20, mTextPaint);
        }
    }

    public void setmProgressColor(int mProgressColor) {
        this.mProgressColor = mProgressColor;
        invalidate();
    }

    public void setmCircleBackground(int mCircleBackground) {
        this.mCircleBackground = mCircleBackground;
        invalidate();
    }

    public void setmProgressValue(int mProgressValue) {
        if (mProgressValue < 0 || mProgressValue > 100) {
            if (mProgressValue < 0) {
                this.mProgressValue = 0;
            } else if (mProgressValue > 100) {
                this.mProgressValue = 100;
            }
        } else {
            this.mProgressValue = mProgressValue;
        }
        postInvalidate();
    }

    public void setmRingWidth(float mRingWidth) {
        this.mRingWidth = mRingWidth;
        invalidate();
    }

    public void setmStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    public void setmSweepAngle(int mSweepAngle) {
        this.mSweepAngle = mSweepAngle;
        invalidate();
    }

    public void setmTopText(String mTopText) {
        this.mTopText = mTopText;
        invalidate();
    }

    public void setmCenterText(String mCenterText) {
        this.mCenterText = mCenterText;
        postInvalidate();
    }

    public void setmBottomText(String mBottomText) {
        this.mBottomText = mBottomText;
        invalidate();
    }

    public void setmTopTextColor(int mTopTextColor) {
        this.mTopTextColor = mTopTextColor;
        invalidate();
    }

    public void setmCenterTextColor(int mCenterTextColor) {
        this.mCenterTextColor = mCenterTextColor;
        invalidate();
    }

    public void setmBottomTextColor(int mBottomTextColor) {
        this.mBottomTextColor = mBottomTextColor;
        invalidate();
    }

    public void setmTopTextSize(float mTopTextSize) {
        this.mTopTextSize = mTopTextSize;
        invalidate();
    }

    public void setmCenterTextSize(float mCenterTextSize) {
        this.mCenterTextSize = mCenterTextSize;
        invalidate();
    }

    public void setmBottomTextSize(float mBottomTextSize) {
        this.mBottomTextSize = mBottomTextSize;
        invalidate();
    }


    //线性逐步显示进度
    @Override
    public void run() {
        float temp = mProgressValue;
        String temp_String = mCenterText;
        if (isNumeric(temp_String)) {
            int center_number = Integer.parseInt(temp_String);
            float number = center_number / temp;
            int centerTextIntTemp = 0;
            for (int i = 1; i <= temp; i++) {
                setmProgressValue(i);
                setmCenterText(String.valueOf(centerTextIntTemp));
                centerTextIntTemp += number;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int i = 1; i <= temp; i++) {
                setmProgressValue(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (temp_String != mCenterText) {
            setmCenterText(temp_String);
        }
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }
}
