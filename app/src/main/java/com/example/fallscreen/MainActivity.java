package com.example.fallscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //有请绘图四大金刚
    ImageView mView;
    Paint p;
    Bitmap bitmap;
    Canvas mCanvas;

    //数据
    LLcou llcou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int vvArray[][];
    protected void Vv_to(int vv[][] ){ //数组赋值到数据类数组中，并记录长度
        int vvlength,vvwidth;
        vvlength = vv.length + 1;
        vvwidth = vv[0].length ;

        vvArray[0][0]=vvlength-1;
        for (int x=1;x<vvlength;x++ ){
            for(int y=0;y<vvwidth;y++){
                vvArray[x][y]=vv[x][y];
            }
        }
    }

    protected void init(){
        // 初始化数据
        llcou = new LLcou();
        llcou.cou =0;

        int vv[][]={
                {1,2,4},
                {2,3,4},
                {5,6,7}
        };
        //Vv_to(vv);
        llcou.alphaFrame =vv;












    }


    protected void Frame (){
        //帧
        //没秒都有

        // 1 从map中抹去上帧的操作 ，暂定涂黑
        mCanvas.drawARGB(255,0,0,0);







    }
    int llCou=0; //光线效果帧计数器

// 显示数据




    protected void LinghtLine(){
        llCou++;






    }







    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }



}
