package com.dlh.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by dlh on 2017/2/8.
 */
public class DlhLableText extends LinearLayout {
    private Context mContext;
    private View contentView;
    private View topLine;
    private RelativeLayout contentLayout;
    private ImageView leftIconIv;
    private TextView leftTv;
    private TextView rightTv;
    private ImageView rightIconIv;
    private View bottomLine;

    public View getContentView() {
        return contentView;
    }

    public void setContentView(View contentView) {
        this.contentView = contentView;
    }

    public View getTopLine() {
        return topLine;
    }

    public void setTopLine(View topLine) {
        this.topLine = topLine;
    }

    public RelativeLayout getContentLayout() {
        return contentLayout;
    }

    public void setContentLayout(RelativeLayout contentLayout) {
        this.contentLayout = contentLayout;
    }

    public ImageView getLeftIconIv() {
        return leftIconIv;
    }

    public void setLeftIconIv(ImageView leftIconIv) {
        this.leftIconIv = leftIconIv;
    }

    public ImageView getRightIconIv() {
        return rightIconIv;
    }

    public void setRightIconIv(ImageView rightIconIv) {
        this.rightIconIv = rightIconIv;
    }

    public TextView getLeftTv() {
        return leftTv;
    }

    public void setLeftTv(TextView leftTv) {
        this.leftTv = leftTv;
    }

    public TextView getRightTv() {
        return rightTv;
    }

    public void setRightTv(TextView rightTv) {
        this.rightTv = rightTv;
    }


    public View getBottomLine() {
        return bottomLine;
    }

    public void setBottomLine(View bottomLine) {
        this.bottomLine = bottomLine;
    }


    private boolean leftIconV;
    private boolean rightIconV;

    private int leftIcon;
    private int rightIcon;

    private int topLineColor;
    private int bottomLineColor;
    private boolean topLineVisibility;
    private boolean bottomLineVisibility;


    public DlhLableText(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public DlhLableText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttributeSet(attrs);
        initView();
    }

    public DlhLableText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initAttributeSet(attrs);
        initView();
    }

    private void initAttributeSet(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.dlhlabletext);
        leftIconV = typedArray.getBoolean(R.styleable.dlhlabletext_leftIconVisibility, false);
        rightIconV = typedArray.getBoolean(R.styleable.dlhlabletext_rightIconVisibility, false);
        leftIcon = typedArray.getResourceId(R.styleable.dlhlabletext_leftIcon, R.drawable.login_user_icon);
        rightIcon = typedArray.getResourceId(R.styleable.dlhlabletext_rightIcon, R.drawable.arrows_right);
        topLineColor = typedArray.getResourceId(R.styleable.dlhlabletext_topLineColor, android.R.color.darker_gray);
        bottomLineColor = typedArray.getResourceId(R.styleable.dlhlabletext_bottomLineColor, android.R.color.darker_gray);
        topLineVisibility = typedArray.getBoolean(R.styleable.dlhlabletext_topLineVisibility, false);
        bottomLineVisibility = typedArray.getBoolean(R.styleable.dlhlabletext_bottomLineVisibility, false);
    }

    protected void initView() {
        contentView = LayoutInflater.from(mContext).inflate(R.layout.dlh_lable_text_layout, this);
        topLine = (View) findViewById(R.id.top_line);
        contentLayout = (RelativeLayout) findViewById(R.id.content_layout);
        leftIconIv = (ImageView) findViewById(R.id.left_icon_iv);
        leftTv = (TextView) findViewById(R.id.left_tv);
        rightTv = (TextView) findViewById(R.id.right_tv);
        rightIconIv = (ImageView) findViewById(R.id.right_icon_iv);
        bottomLine = (View) findViewById(R.id.bottom_line);
    }


}
