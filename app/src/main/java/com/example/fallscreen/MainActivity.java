package com.example.fallscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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


        mView = (ImageView) findViewById(R.id.imageView);
        p = new Paint();
        p.setColor(Color.argb(255, 255, 100, 100));
        bitmap = Bitmap.createBitmap(1080, 2250, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);

        mCanvas.drawARGB(255, 0, 0, 0);
        //  mCanvas.drawRect(10, 10, 200, 200, p);
        // mCanvas.drawARGB(255,0,0,0);
        mView.setImageBitmap(bitmap);


        llcou = new LLcou();

        //testpaint();
//test2();

        DrawRing(30, 820, 100, 100, 100);


        // new Thread(new TimThread ()).start();


    }


    int vvArray[][];

    protected void Vv_to(int vv[][]) { //数组赋值到数据类数组中，并记录长度
        int vvlength, vvwidth;
        vvlength = vv.length + 1;
        vvwidth = vv[0].length;

        vvArray[0][0] = vvlength - 1;
        for (int x = 1; x < vvlength; x++) {
            for (int y = 0; y < vvwidth; y++) {
                vvArray[x][y] = vv[x][y];
            }
        }
    }


    protected void Frame() {
        //帧
        //没秒都有

        // 1 从map中抹去上帧的操作 ，暂定涂黑
        mCanvas.drawARGB(255, 0, 0, 0);


    }

    int llCou = 0; //光线效果帧计数器

// 显示数据


    protected void LinghtLine() {
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


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    System.out.println("接收到DownloadThread发送的消息:" + msg.arg1);
                    testpaint();
                    break;
            }

        }
    };


    public class TimThread extends Thread {


        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5);//每隔1s执行一次
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

    protected void testpaint() {

        pl++;
        pt++;
        pr++;
        pb++;

        mCanvas.drawARGB(255, 0, 0, 0);
        //mCanvas.drawRect(pl+10, pt+10, pr+200, pb+200, p);
        // mCanvas.drawARGB(255,0,0,0);
        // 直线 曲线 曲线角度

        int tvary_index = 1;//当前颜色标记的位置
        int tVary = 0;
        tVary = llcou.lightline[tvary_index][3]; //取得第一个颜色终点数据
        p.setARGB(255, llcou.lightline[1][0], llcou.lightline[1][1], llcou.lightline[1][2]);
        for (int i = 1; i < llcou.lightline[0][0]; i++) {

            mCanvas.drawPoints(new float[]{100, 200 + i, 101, 200 + i}, p);
            if (tVary == i) {

                tvary_index++;
                tVary = llcou.lightline[tvary_index][3];
                p.setARGB(255, llcou.lightline[tvary_index][0], llcou.lightline[tvary_index][1], llcou.lightline[tvary_index][2]);


            }


        }


        mView.setImageBitmap(bitmap);


    }

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


        //mCanvas.drawArc(461, -70, 619, 100, 170, -160, false, p);


        mCanvas.drawArc(618, 5, 720, 60, 180, 85, false, p);

        //mCanvas.drawLine(668,5,985,5,p);

        //mCanvas.drawArc(895,5,1075,180,0,-90,false,p);


        //mCanvas.drawLine(1074,93,1074,2145,p);


        //mCanvas.drawArc(895,2055,1075,2235,90,-90,false,p);


        // mCanvas.drawLine(93,2235,986,2235,p);

        //mCanvas.drawArc(5,2055,180,2235,180,-90,false,p);

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


    protected void DrawRing(int dstart, int dlong, int cR, int cG, int cB) {


    /*
    总控制长度 为 1000 点约为 6343 每个角度 算作一个点



    读出数据

    先判断 dstart 的值 位于哪个线段上 跨越几个线段


     */

        //判断位于那一段
        int rplength = llcou.ringPath.length;
        int allpathlong = 6343;
        float rpspot = allpathlong / 1000; //每d点 对应的实际点长

        int dsspot = (int) (dstart * rpspot); //开始点位
        int dsspotOK = 0;
        int dslongspot = (int) (dlong * rpspot); // 点位长度
        int dslongspotOK = 0;
        int starpar = 0;
        int endpar = 0;
        int before = 0;
        int beadd = 0;
        int enLine = 0; //最后一段线的线长度
        int stLine = 0;  //起点位置
        int theStLine = 0;
        int theEnLine = 0;

        p.setARGB(255, 255, 255, 255);
        p.setStyle(Paint.Style.STROKE);
        mCanvas.drawARGB(255, 0, 0, 0);


        for (int i = 0; i < rplength; i++) {


            if (dlong <= (beadd + llcou.ringPath[i][7]) && dslongspotOK == 0) {

                dslongspotOK = 1; //已经找到 关闭查找状态
                endpar = i;

                enLine = dlong - beadd;


            }


            if (dstart <= (beadd + llcou.ringPath[i][7]) && dsspotOK == 0) {

                dsspotOK = 1; //已经找到 关闭查找状态
                starpar = i;  //得出起点位于的线段

                stLine = dstart - beadd; //求出固定线段的起点


                // 开始和结束都位于一个线段


            }

            beadd = beadd + llcou.ringPath[i][7];

        }
        for (int i = starpar; i <= endpar; i++) {

            if (i == 0) {

                if (starpar == i && endpar == i) {

                    mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, enLine - stLine, false, p);


                }


                if (starpar == i && endpar > i) { // 如果是开始

                    mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, 90-stLine , false, p);

                }

                if (starpar < i && endpar > i) {

                    mCanvas.drawArc(5, 5, 180, 180, 180, 90, false, p);

                }


            }


            if (i == 1) {

                if(starpar != i){
                    stLine=0;
                }


                if (endpar == i) {
                    mCanvas.drawLine(93 + stLine, 5, 93 + enLine - stLine, 5, p);
                }


                if (starpar == i && endpar > i) { // 如果是开始但 没有结束


                    mCanvas.drawLine(93 + stLine, 5, 412 , 5, p);

                }
                if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段

                    mCanvas.drawLine(93, 5, 412, 5, p);

                }

            }


            if (i == 2) {
                if(starpar != i){
                    stLine=0;
                }

                //mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, enLine - stLine, false, p);
                if (endpar == i) {
                    mCanvas.drawArc(360, 5, 462, 60, -90 + stLine, enLine - stLine, false, p);
                }


                if (starpar == i && endpar > i) { // 如果是开始

                    mCanvas.drawArc(360, 5, 462, 60, -90 + stLine, 90 , false, p);
                }

                if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段

                    mCanvas.drawArc(360, 5, 462, 60, -90, 85, false, p);
                }
            }



            if (i == 3) {
                if(starpar != i){
                    stLine=0;
                }

                //mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, enLine - stLine, false, p);
                if (endpar == i) {

                    mCanvas.drawArc(461, -70, 619, 100, 170+stLine, (enLine - stLine)* -1, false, p);
                }


                if (starpar == i && endpar > i) { // 如果是开始

                    mCanvas.drawArc(461, -70, 619, 100, 170 + stLine, (160 - stLine)* -1, false, p);


                }

                if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段


                    mCanvas.drawArc(461, -70, 619, 100, 170, -160, false, p);
                }
            }






            if (i == 3) {
                if(starpar != i){
                    stLine=0;
                }

                //mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, enLine - stLine, false, p);
                if (endpar == i) {

                    mCanvas.drawArc(461, -70, 619, 100, 170+stLine, (enLine - stLine)* -1, false, p);
                }


                if (starpar == i && endpar > i) { // 如果是开始

                    mCanvas.drawArc(461, -70, 619, 100, 170 + stLine, (160 - stLine)* -1, false, p);


                }

                if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段


                    mCanvas.drawArc(461, -70, 619, 100, 170, -160, false, p);
                }
            }





            if (i == 4) {
                if(starpar != i){
                    stLine=0;
                }

                //mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, enLine - stLine, false, p);
                if (endpar == i) {

                    mCanvas.drawArc(618, 5, 720, 60, 180+stLine, enLine - stLine, false, p);



                }


                if (starpar == i && endpar > i) { // 如果是开始

                    mCanvas.drawArc(618, 5, 720, 60, 180+stLine, 85, false, p);

                }

                if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段


                    mCanvas.drawArc(618, 5, 720, 60, 180, 85, false, p);
                }
            }






        }


        int spanpar = endpar - starpar; //跨距
        int past = 0;


        mView.setImageBitmap(bitmap);


    }


}






