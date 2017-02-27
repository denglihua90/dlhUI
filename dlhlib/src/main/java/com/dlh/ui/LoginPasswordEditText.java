package com.dlh.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by dlh on 16/12/16.
 *
 */
public class LoginPasswordEditText extends LinearLayout {
    private Context mContext;
    private ImageView leftiv;
    private EditText eidttext;
    private ImageView showpassiv;
    private ImageView rightiv;

    private boolean isPasswordMode = false;

    private boolean mhasFocus = false;

    private boolean leftVisibility = false;
    private int leftIcon = 0;

    public boolean isPasswordMode() {
        return isPasswordMode;
    }

    /**
     * 设置 是否为密码模式
     *
     * @param passwordMode
     */
    public void setPasswordMode(boolean passwordMode) {
        isPasswordMode = passwordMode;
        if (isPasswordMode && eidttext != null) {
            eidttext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    /**
     * 设置 是否为手机号码模式
     */
    public void setPhoneMode() {
        if (eidttext != null) {
            eidttext.setInputType(InputType.TYPE_CLASS_PHONE);
        }
    }

    public ImageView getLeftiv() {
        return leftiv;
    }

    public void setLeftiv(ImageView leftiv) {
        this.leftiv = leftiv;
    }

    public EditText getEidttext() {
        return eidttext;
    }

    public void setEidttext(EditText eidttext) {
        this.eidttext = eidttext;
    }

    public ImageView getShowpassiv() {
        return showpassiv;
    }

    public void setShowpassiv(ImageView showpassiv) {
        this.showpassiv = showpassiv;
    }

    public ImageView getRightiv() {
        return rightiv;
    }

    public void setRightiv(ImageView rightiv) {
        this.rightiv = rightiv;
    }

    public LoginPasswordEditText(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public LoginPasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttributeSet(attrs);
        initView();
    }

    public LoginPasswordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initAttributeSet(attrs);
        initView();
    }

    private void initAttributeSet(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.login_text);
        isPasswordMode = typedArray.getBoolean(R.styleable.login_text_mode, false);
        leftVisibility = typedArray.getBoolean(R.styleable.login_text_leftVisibility, false);
        leftIcon = typedArray.getResourceId(R.styleable.login_text_loginleftIcon, R.drawable.delete_selector);
    }
    private void initView() {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.login_pass_edit_layout, this);
        this.rightiv = (ImageView) view.findViewById(R.id.right_iv);
        this.showpassiv = (ImageView) view.findViewById(R.id.show_pass_iv);
        this.eidttext = (EditText) view.findViewById(R.id.eidt_text);
        this.leftiv = (ImageView) view.findViewById(R.id.left_iv);
        leftiv.setVisibility(leftVisibility == true ? VISIBLE : GONE);
        if (leftIcon != 0) {
            leftiv.setImageResource(leftIcon);
        } else {
            leftiv.setVisibility(INVISIBLE);
        }

        Log.i("dlh","isPasswordMode-->"+isPasswordMode);
        if (isPasswordMode && eidttext != null) {
            eidttext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            if (eidttext != null) {
                eidttext.setInputType(InputType.TYPE_CLASS_PHONE);
            }
        }
        eidttext.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mhasFocus = hasFocus;
                if (eidttext.getText().length() > 0 && mhasFocus) {
                    rightiv.setVisibility(VISIBLE);
                    if (isPasswordMode) {
                        showpassiv.setVisibility(VISIBLE);
                    } else {
                        showpassiv.setVisibility(GONE);
                    }

                } else {
                    rightiv.setVisibility(GONE);
                    showpassiv.setVisibility(GONE);

                }

            }
        });
        eidttext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (eidttext.getText().length() > 0 && mhasFocus) {
                    rightiv.setVisibility(VISIBLE);
                    if (isPasswordMode) {
                        showpassiv.setVisibility(VISIBLE);
                    } else {
                        showpassiv.setVisibility(GONE);
                    }

                } else {
                    rightiv.setVisibility(GONE);
                    showpassiv.setVisibility(GONE);

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rightiv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                eidttext.setText("");
            }
        });
        showpassiv.setTag(1);
        showpassiv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer) v.getTag() == 1) {
                    showpassiv.setTag(0);
                    eidttext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    eidttext.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showpassiv.setTag(1);
                }
            }
        });
    }


}
