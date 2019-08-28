package com.example.fallscreen;


public class LLcou {
    public int cou; // 帧计数器
    public char Width; //宽度
    // 当前位置 也就是帧 计数器

    // 色彩二维数组
    // 记录若干组线的每个点的亮度色彩 预留了 阿尔法值单元 但是未启用
    // 【R】【G】【B】【A】
    //  第一行记录线长度
    int[][] lightline = new int[50][4];


    // 长度 - 位置   可变的长度
    // 第一行 数据总长
    int[][] lengthFrame = new int[1204][2];



    // 速度 - 位置  从上一位置到这一位置需要的 帧 或者 时间
    int[][] speedFrame = new int[1024][2];


    // 亮度 - 位置  是一个 阿尔法通道的值
    int[][]  alphaFrame = new int[1024][2];



    // 每帧计算出 上述值得变化

    // 环数据 ，记录一圈点 的坐标，主要记录圆弧，通过算法 计算出角和园














}

