package com.example.module_main.widgets;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewColorAnimator extends AppCompatTextView {
    private String myTextColor;

    public TextViewColorAnimator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setMyTextColor(String color){

        setTextColor(Color.parseColor(color));
        myTextColor = color;
        invalidate();
    }

    public String getMyTextColor(){
        return myTextColor;
    }
}
