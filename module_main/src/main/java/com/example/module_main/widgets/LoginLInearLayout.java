package com.example.module_main.widgets;

import android.content.ContentValues;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.example.module_main.MainLoginActivity;
import com.example.module_main.R;

import java.lang.ref.WeakReference;

public class LoginLInearLayout extends LinearLayout {
    private MainLoginActivity context;
    private ImageView imageView;
    private RelativeLayout rlBackground;
    private TextViewColorAnimator tvLoginSign;
    private boolean keyBoardShow; //键盘是否弹出\

    public LoginLInearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = (MainLoginActivity) context;

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        imageView = this.context.findViewById(R.id.login_sign_background);
        rlBackground = this.context.findViewById(R.id.login_sign_rl);
        tvLoginSign = this.context.findViewById(R.id.main_login_sign);
        int width = r - l;
        int height = b - t;
        if (changed) {
            LayoutParams vgLayout = (LayoutParams) rlBackground.getLayoutParams();
            RelativeLayout.LayoutParams tvLoginSignLayout = (RelativeLayout.LayoutParams) tvLoginSign.getLayoutParams();
            // 键盘高宽比小于 2/3，判定软键盘弹出
            if (height / width < 2f / 3f) {
                keyBoardShow = true;
                vgLayout.weight = 5f;
                tvLoginSignLayout.removeRule(RelativeLayout.CENTER_IN_PARENT);
                tvLoginSignLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                tvLoginSignLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
                imageView.setVisibility(INVISIBLE);
            } else {
                keyBoardShow =false;
                vgLayout.weight = 5f;
                tvLoginSignLayout.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                tvLoginSignLayout.removeRule(RelativeLayout.CENTER_HORIZONTAL);
                tvLoginSignLayout.addRule(RelativeLayout.CENTER_IN_PARENT);
                imageView.setVisibility(VISIBLE);
            }
            tvLoginSign.setLayoutParams(tvLoginSignLayout);
            rlBackground.setLayoutParams(vgLayout);
        }
    }
}
