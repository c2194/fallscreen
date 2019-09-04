

        package com.example.fallscreen;

        import android.graphics.Bitmap;
        import android.graphics.Canvas;
        import android.graphics.Paint;
        import android.widget.ImageView;

        public class Edraw1 {

        int varE_1_theF = 0;
        int m_The_Frame = 0;

        ImageView mView;
        Paint p;
        Bitmap bitmap;
        Canvas mCanvas;



        LLcou llcou;

        public  Edraw1(ImageView imView,Paint ip,Bitmap ibitmap,Canvas imCanvas, LLcou illcou) {

        mView=imView;
        p=ip;
        bitmap=ibitmap;
        mCanvas=imCanvas;
        llcou=illcou;

        int l1s_add=10;
        line_1_Speed =  new int[17][7];
        int v3=0;int v4=0;int v2=0;;int v5=0;int v6=0; int v7=0;

        aAdd=0;

        v4=150;
        v2=1;v3=v3+2;v5=50;v6=30;v7=30;
        arrayAdd(line_1_Speed,16,0,v2,v3,v4,v5,v6,v7);
        v2=v2+1;v3=v3+20;v5=40;v6=40;v7=40;
        arrayAdd(line_1_Speed,0,0,v2,v3,v4,v5,v6,v7);
        v2=v2+1;v3=v3+10;v5=v5+70;v6=v6+70;v7=v7+70;
        arrayAdd(line_1_Speed,1,0,v2,v3,v4,v5,v6,v7);
        v2=v2+2;v3=v3+10;v5=v5+100;v6=v6+100;v7=v7+100;
        arrayAdd(line_1_Speed,2,0,v2,v3,v4,v5,v6,v7);
        v2=v2+1;v3=v3+60;  v5=v5+55;  v6=v6+55;  v7=v7+55;
        arrayAdd(line_1_Speed,3,0,v2,v3,v4,v5,v6,v7);
        v2=v2-2;v3=v3+95;v5=v5-55;v6=v6-55;v7=v7-55;
        arrayAdd(line_1_Speed,4,0,v2,v3,v4,v5,v6,v7);
        v2=v2-1;v3=v3+20;v5=v5-40;v6=v6-40;v7=v7-40;
        arrayAdd(line_1_Speed,5,0,v2,v3,v4,v5,v6,v7);
        v3=v3+20;v5=v5-40;v6=v6-40;v7=v7-40;
        arrayAdd(line_1_Speed,6,0,v2,v3,v4,v5,v6,v7);
        v3=v3+20;v5=v5-40;v6=v6-40;v7=v7-40;
        arrayAdd(line_1_Speed,7,0,v2,v3,v4,v5,v6,v7);
        v3=v3+20;v5=v5-40;v6=v6-40;v7=v7-40;
        arrayAdd(line_1_Speed,8,0,v2,v3,v4,v5,v6,v7);
        v2=v2-2;v3=v3-30;
        arrayAdd(line_1_Speed,9,0,v2,v3,v4,v5,v6,v7);
        v2=v2-2;v3=v3-5;
        arrayAdd(line_1_Speed,10,0,v2,v3,v4,v5,v6,v7);
        v2=v2-2;v3=v3-5;
        arrayAdd(line_1_Speed,11,0,v2,v3,v4,v5,v6,v7);
        v2=v2-2;v3=v3-5;
        arrayAdd(line_1_Speed,12,0,v2,v3,v4,v5,v6,v7);
        v2=1;v3=v3-5;
        arrayAdd(line_1_Speed,13,0,v2,v3,v4,v5,v6,v7);

        arrayAdd(line_1_Speed,14,0,v2,v3,v4,v5,v6,v7);

        arrayAdd(line_1_Speed,15,0,v2,v3,v4,v5,v6,v7);







        }

        int aAdd=0;
        public void arrayAdd(int[][] arr,int arrnum,int v1,int v2,int v3,int v4 ,int vR ,int vG,int vB){

        arr[aAdd][0]=v1;
        arr[aAdd][1]=v2;
        arr[aAdd][2]=v3;
        arr[aAdd][3]=v4;
        arr[aAdd][4]=vR;
        arr[aAdd][5]=vG;
        arr[aAdd][6]=vB;
        aAdd++;

        }



        int line_1_Frame = 2000;
        int line_1_the_Frame = 0;
        int[][] line_1_Speed ;
        int up_st=1,up_en=2;
        public void Run_next() {
        m_The_Frame++;

        if(m_The_Frame< 300) {

        drawing_line1();
        }



        mView.setImageBitmap(bitmap);


        }

        int dl_1_LP = 1;
        int l_1_Key_N = 1; //下一个关键帧切换点
        int st = 0, en = 0;
        float teR=0,teG=0,teB=0;
        float nR=0,nG=0,nB=0;
        int hR=0,hG=0,hB=0;

        protected void drawing_line1() {



        if (l_1_Key_N < line_1_Speed.length) {
        if (m_The_Frame == line_1_Speed[l_1_Key_N][2]) {

        //帧数据切换
        l_1_Key_N++;

        System.out.println(" --- >>" + line_1_Speed[l_1_Key_N][2] + " --- " +line_1_Speed[l_1_Key_N-1][2]);

        if(line_1_Speed[l_1_Key_N][4]>line_1_Speed[l_1_Key_N-1][4] || line_1_Speed[l_1_Key_N][4]<line_1_Speed[l_1_Key_N-1][4]){


        //求出单帧的变化值--浮点类型
        nR=(float)(line_1_Speed[l_1_Key_N][2]-line_1_Speed[l_1_Key_N-1][2]) / (line_1_Speed[l_1_Key_N][4] - line_1_Speed[l_1_Key_N-1][4]);

        }else{
        nR =0;
        }

        if(line_1_Speed[l_1_Key_N][5]>line_1_Speed[l_1_Key_N-1][5] ||line_1_Speed[l_1_Key_N][5]<line_1_Speed[l_1_Key_N-1][5] ){


        //求出单帧的变化值--浮点类型
        nG=(float)(line_1_Speed[l_1_Key_N][2]-line_1_Speed[l_1_Key_N-1][2]) / (line_1_Speed[l_1_Key_N][5] - line_1_Speed[l_1_Key_N-1][5]);

        }else{
        nG=0;
        }


        if(line_1_Speed[l_1_Key_N][6]>line_1_Speed[l_1_Key_N-1][6] || line_1_Speed[l_1_Key_N][6]<line_1_Speed[l_1_Key_N-1][6] ){


        //求出单帧的变化值--浮点类型
        nB=(float)(line_1_Speed[l_1_Key_N][2]-line_1_Speed[l_1_Key_N-1][2]) / (line_1_Speed[l_1_Key_N][6] - line_1_Speed[l_1_Key_N-1][6]);

        }else {

        nB=0;

        }



        }
        }


        st = st + line_1_Speed[l_1_Key_N - 1][1];
        en = st + line_1_Speed[l_1_Key_N - 1][3];

        teR = teR+nR;
        teG = teG+nG;
        teB = teB+nB;


        int oR=0,oG=0,oB=0;

        oR=  line_1_Speed[l_1_Key_N - 1][4]+(int)teR;
        oG= line_1_Speed[l_1_Key_N - 1][5]+(int)teG;
        oB= line_1_Speed[l_1_Key_N - 1][6]+(int)teB;

        if (oR > 255) oR=255;
        if (oG > 255) oG=255;
        if (oB > 255) oB=255;
        if(oR<0) oR=0;
        if(oG<0) oG=0;
        if(oB<0) oB=0;


        DrawRing(up_st,up_en,1,1,1);
        DrawRing(st, en, oR, oG, oB);
        up_en=en;
        up_st =st;

        System.out.println(st + " | " + en  +" | " + oR + " | " + oG + " | " + oB  );




        }







        int[][] l2_rgb = new int[][]{

                {0,50,50,50},
                {10,220,220,220},
                {10,255,255,255},
                {12,50,50,50},
                {10,180,180,180},
                {10,50,50,50},
                {12,255,255,255},
                {100,30,30,30},


        } ;

        float nR2=0,nG2=0,nB2=0;
        float teR2=0,teB2=0,teG2=0;

        protected void drawing_line_2(){



        }





        public void DrawRing(int dstart, int dlong, int cR, int cG, int cB) {


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

        p.setARGB(255, cR, cG, cB);
        p.setStyle(Paint.Style.STROKE);
        mCanvas.drawARGB(0, 0, 0, 0);


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
        mCanvas.drawLine(93 + stLine, 5, 93 + enLine , 5, p);
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

        mCanvas.drawArc(360, 5, 462, 60, -90 + stLine, 90-stLine , false, p);
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

        mCanvas.drawArc(461, -70, 619, 100, 170- stLine, (enLine - stLine)* -1, false, p);


        }


        if (starpar == i && endpar > i) { // 如果是开始

        mCanvas.drawArc(461, -70, 619, 100, 170 - stLine, (155 - stLine)*-1, false, p);


        }

        if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段


        mCanvas.drawArc(461, -70, 619, 100, 170, -155, false, p);
        }
        }





        if (i == 4) {
        if(starpar != i){
        stLine=0;
        }

        //mCanvas.drawArc(5, 5, 180, 180, 180 + stLine, enLine - stLine, false, p);
        if (endpar == i) {

        mCanvas.drawArc(616, 5, 720, 76, 185+stLine, enLine - stLine, false, p);


        }


        if (starpar == i && endpar > i) { // 如果是开始

        mCanvas.drawArc(616, 5, 720, 76, 185+stLine, 90-stLine , false, p);

        }

        if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段


        mCanvas.drawArc(616, 5, 720, 76, 185, 90, false, p);
        }
        }



        if (i == 5) {

        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {
        mCanvas.drawLine(668 + stLine, 5, 668 + enLine , 5, p);

        }


        if (starpar == i && endpar > i) { // 如果是开始但 没有结束


        mCanvas.drawLine(668 + stLine, 5, 985 , 5, p);

        }
        if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段

        mCanvas.drawLine(668,5,985,5,p);

        }

        }



        if (i == 6) {


        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {




        mCanvas.drawArc(895,5,1075,180,270+stLine,enLine - stLine,false,p);


        }


        if (starpar == i && endpar > i) { // 如果是开始
        mCanvas.drawArc(895,5,1075,180,270+stLine,90-stLine,false,p);



        }

        if (starpar < i && endpar > i) {

        mCanvas.drawArc(895,5,1075,180,270,90,false,p);

        }


        }



        if (i == 7) {

        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {

        mCanvas.drawLine(1074,93+stLine,1074,93+enLine ,p);
        }


        if (starpar == i && endpar > i) { // 如果是开始但 没有结束


        ;
        mCanvas.drawLine(1074,93+stLine,1074,2145,p);

        }
        if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段

        mCanvas.drawLine(1074,93,1074,2145,p);

        }

        }



        if (i == 8) {


        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {




        mCanvas.drawArc(895,2055,1075,2235,0+stLine,enLine - stLine,false,p);

        }


        if (starpar == i && endpar > i) { // 如果是开始

        mCanvas.drawArc(895,2055,1075,2235,0+stLine,90-stLine,false,p);


        }

        if (starpar < i && endpar > i) {

        mCanvas.drawArc(895,2055,1075,2235,0,90,false,p);

        }


        }







        if (i == 9) {

        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {



        mCanvas.drawLine(986-stLine,2235,986-enLine,2235,p);



        }


        if (starpar == i && endpar > i) { // 如果是开始但 没有结束




        mCanvas.drawLine(93,2235,986-stLine,2235,p);

        }
        if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段

        mCanvas.drawLine(986,2235,93,2235,p);

        }

        }


        if (i == 10) {


        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {





        mCanvas.drawArc(5,2055,180,2235,90+stLine,enLine ,false,p);




        }


        if (starpar == i && endpar > i) { // 如果是开始


        mCanvas.drawArc(5,2055,180,2235,90+stLine,90-stLine,false,p);


        }

        if (starpar < i && endpar > i) {

        mCanvas.drawArc(5,2055,180,2235,90,90,false,p);

        }


        }






        if (i == 11) {

        if(starpar != i){
        stLine=0;
        }


        if (endpar == i) {




        mCanvas.drawLine(5,2145-enLine,5,2145-stLine,p);



        }


        if (starpar == i && endpar > i) { // 如果是开始但 没有结束






        mCanvas.drawLine(5,2145-stLine,5,2145,p);

        }
        if (starpar < i && endpar > i) {  // 如果是中间线段则画完整线段

        mCanvas.drawLine(5,93,5,2145,p);

        }

        }






        }


        int spanpar = endpar - starpar; //跨距
        int past = 0;





        }




        



        }
