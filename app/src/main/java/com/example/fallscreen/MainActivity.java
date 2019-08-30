package com.example.fallscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
        mCanvas.drawRect(10, 10, 200, 200, p);
        // mCanvas.drawARGB(255,0,0,0);
        mView.setImageBitmap(bitmap);



        llcou = new LLcou();

        //testpaint();
test2();





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
            switch (msg.what){
                case 1:
                    System.out.println("接收到DownloadThread发送的消息:"  + msg.arg1);
                    testpaint();
                    break;
            }

        }
    };



    public class TimThread extends Thread {


        @Override
        public void run() {
            while (true){
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


    int pl,pt,pr,pb;

    protected void testpaint(){

        pl++;
        pt++;
        pr++;
        pb++;

        mCanvas.drawARGB(255, 0, 0, 0);
        //mCanvas.drawRect(pl+10, pt+10, pr+200, pb+200, p);
        // mCanvas.drawARGB(255,0,0,0);
        // 直线 曲线 曲线角度

        int tvary_index=1;//当前颜色标记的位置
        int tVary=0;
        tVary=llcou.lightline[tvary_index][3]; //取得第一个颜色终点数据
        p.setARGB(255,llcou.lightline[1][0],llcou.lightline[1][1],llcou.lightline[1][2]);
        for (int i=1;i<llcou.lightline[0][0];i++){

            mCanvas.drawPoints(new float[]{100,200+i,101,200+i},p);
            if(tVary == i){

                tvary_index++;
                tVary=llcou.lightline[tvary_index][3];
                p.setARGB(255,llcou.lightline[tvary_index][0],llcou.lightline[tvary_index][1],llcou.lightline[tvary_index][2]);



            }


        }



        mView.setImageBitmap(bitmap);




    }

    protected void test2(){

        p.setARGB(255,255,255,255);
        mCanvas.drawARGB(255, 30, 0, 0);


        int larrlong = llcou.fPath.length;

        //for(int i=1;i<larrlong;i++) {

          //  mCanvas.drawLine(llcou.fPath[i-1][0],llcou.fPath[i-1][1],llcou.fPath[i][0],llcou.fPath[i][1], p);

        //}
        p.setStyle(Paint.Style.STROKE);

        //RectF rectf = new RectF(220,220,600,600);



        mCanvas.drawArc(5,5,180,180,180,90,false,p);





        mCanvas.drawArc(461,-70,619,100,170,-160,false,p);

        mCanvas.drawLine(80,5,420,5,p);



        mCanvas.drawArc(360,5,462,60,-90,85,false,p);

//        mCanvas.drawArc(620,5,722,60,180,85,false,p);

        mCanvas.drawArc(618,5,720,60,-90,-85,false,p);

        mCanvas.drawLine(670,5,985,5,p);

        mCanvas.drawArc(895,5,1075,180,0,-90,false,p);


        mCanvas.drawLine(1074,93,1074,2000,p);



    }




}


