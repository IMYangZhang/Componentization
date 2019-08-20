package com.example.module_main;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeScroll;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.widget.TextView;

import com.example.lib_common.adapter.TransitionListenAdapter;
import com.example.lib_common.animator.ColorEvaluator;
import com.example.lib_common.base.BaseActivity;
import com.example.module_main.widgets.TextViewColorAnimator;

import org.greenrobot.eventbus.EventBus;

public class MainLoginActivity extends BaseActivity {
    private TextViewColorAnimator tv_login_sign;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setEnterTransition(new Fade()); // 设置当前activity以淡入的方式进入
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login_activity);
        tv_login_sign = findViewById(R.id.main_login_sign);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());   // 大小与位置动画
//        transitionSet.addTransition(new ChangeTransform()); // 缩放与旋转动画
//        transitionSet.addTransition(new ChangeClipBounds()); // 裁剪区域
//        transitionSet.addTransition(new ChangeScroll()); // 处理View的scrollX与scrollY属性
//        transitionSet.addTransition(new ChangeImageTransform()); //处理ImageView的ScaleType属性
        transitionSet.addTarget(tv_login_sign); // 添加过场动画目标
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);

        /// 属性动画
        ObjectAnimator animator = ObjectAnimator.ofInt(tv_login_sign,"textColor",
                getResources().getColor(R.color.colorBlue,null),getResources().getColor(R.color.colorAccent,null));
//        ObjectAnimator animator = ObjectAnimator.ofFloat(tv_login_sign,"textSize",20,30);
        animator.setEvaluator(new ColorEvaluator()); // 设置估值器
        animator.setDuration(1000);
        animator.start();
    }
}
