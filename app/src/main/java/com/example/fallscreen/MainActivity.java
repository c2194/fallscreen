package com.example.fallscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //有请绘图四大金刚
    ImageView mView;
    Paint p;
    Bitmap bitmap;
    Canvas mCanvas;

    //数据
    LLcou llcou;
    Edraw1 edraw1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ////

        TextView tview1 = (TextView) findViewById(R.id.textView);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/Electrolize-Regular.ttf");
        tview1.setTypeface(typeface);


        ///




        mView = (ImageView) findViewById(R.id.imageView);
        p = new Paint();
        p.setColor(Color.argb(255, 255, 100, 100));
        bitmap = Bitmap.createBitmap(1080, 2250, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);

        mCanvas.drawARGB(160, 0, 0, 0);
        //  mCanvas.drawRect(10, 10, 200, 200, p);
        // mCanvas.drawARGB(255,0,0,0);
        mView.setImageBitmap(bitmap);


        llcou = new LLcou();

        //testpaint();
//test2();


      //  DrawRing(1186, 1336, 100, 100, 100);

        edraw1= new Edraw1(mView,p,bitmap,mCanvas,llcou);

      //  edraw1.DrawRing(1186, 1336, 100, 100, 100);
         new Thread(new TimThread ()).start();

     //   edraw1.DrawRing(1,150,0,0,0);



        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
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


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //System.out.println("接收到DownloadThread发送的消息:" + msg.arg1);
                    //testpaint();

                    animation();

                    break;
            }

        }
    };


    public class TimThread extends Thread {


        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(20);//每隔1s执行一次
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }


    int pl, pt, pr, pb;


    protected void test2() {

        p.setARGB(255, 255, 255, 255);
        mCanvas.drawARGB(255, 0, 0, 0);


        //int larrlong = llcou.fPath.length;

        //for(int i=1;i<larrlong;i++) {

        //  mCanvas.drawLine(llcou.fPath[i-1][0],llcou.fPath[i-1][1],llcou.fPath[i][0],llcou.fPath[i][1], p);

        //}
        p.setStyle(Paint.Style.STROKE);

        //RectF rectf = new RectF(220,220,600,600);


       // mCanvas.drawArc(5, 5, 180, 180, 180, 90, false, p);


       // mCanvas.drawLine(93, 5, 412, 5, p);


       // mCanvas.drawArc(360, 5, 462, 60, -90, 85, false, p);


        mCanvas.drawArc(461, -70, 619, 100, 170, -60, false, p);


       // mCanvas.drawArc(616, 5, 720, 76, 185, 90, false, p);

        mCanvas.drawLine(668,5,985,5,p);

        mCanvas.drawArc(895,5,1075,180,270,90,false,p);


        mCanvas.drawLine(1074,93,1074,2145,p);


        mCanvas.drawArc(895,2055,1075,2235,0,45,false,p);


         mCanvas.drawLine(986,2235,986 -780,2235,p);

        mCanvas.drawArc(5,2055,180,2235,90,90,false,p);

        //mCanvas.drawLine(5,93,5,2145,p);

        mView.setImageBitmap(bitmap);

    }


    //方法设想
    /*

     先定义一个线长度，然后 写线上的特征标记 ，根据特征标记画
     特征有 四个角 ，左 右 眉峰 眉尖半圆
     总长度 估计：

     90       319    85      85         317     90
                         180


      2052                                     2052



      90                 893                     90
     */




    int thestep =1;

    protected void animation(){ //动画控制器

        //每次都要到来这里

        /*

        主过程器
        |         效果过程器 （目前控制时序)
        |----        |
                     |---步骤
                     |
                     |
        |
        |
        |
         */



thestep++;
edraw1.Run_next();




    }
    int varE_1_theF=0;








}






