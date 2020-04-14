package com.education.samson.G8NumberTheory;

public class dataBase {
    static int[] nonFraction = {0,1,1,1,      0,0,0,1,      1,1,1,1,      1,1,1,1,       0,1,0,1,     1,1,1,0};
    static int[] answerFormat = {0,1,1,1,     1,1,1,0,      1,0,1,0,      1,1,1,1,       0,1,0,1,     0,1,0,0};
    static double[][][][] blankAnswer = {
            //0
            {{{3,0,0},{2,1,2},{3,13,24},{0,0,0}},   {{4,0,0},{3,1,2},{6,1,25},{0,0,0}}},
            //1
            {{{20,0,0},{0.2,0,0},{0,0,0},{0,0,0}},     {{33,0,0},{0.33,0,0},{0,0,0},{0,0,0}}},
            //2
            {{{0,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{0,0,0},{0,0,0},{0,0,0},{0,0,0}}},
            //3
            {{{297,0,0},{528,0,0},{0,0,0},{0,0,0}},   {{231,0,0},{528,0,0},{0,0,0},{0,0,0}}},
            //4
            {{{25,0,0},{0,1,4},{0,25,100},{0,0,0}},   {{40,0,0},{0,2,5},{0,40,100},{0,0,0}}},
            //5
            {{{12,1,2},{11,1,9},{7,0,0},{0,0,0}},   {{16,2,3},{14,2,7},{13,0,0},{0,0,0}}},
            //6
            {{{11,13,17},{13,1,3},{0,2,17},{0,0,0}},    {{7,9,13},{8,1,3},{0,1,13},{0,0,0}}},
            //7
            {{{0,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{0,0,0},{0,0,0},{0,0,0},{0,0,0}}},
            //8
            {{{68,0,0},{36,0,0},{0,0,0},{0,0,0}},     {{33,0,0},{21,0,0},{0,0,0},{0,0,0}}},
            //9
            {{{0,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{0,0,0},{0,0,0},{0,0,0},{0,0,0}}},
            //10
            {{{22.22,0,0},{0.22,0,0},{22,0,0},{0,0,0}},   {{13.33,0,0},{0.13,0,0},{13,0,0},{0,0,0}}},
            //11
            {{{0,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{0,0,0},{0,0,0},{0,0,0},{0,0,0}}},
            //12
            {{{2.87,0,0},{19.35,0,0},{2.86,0,0},{0,0,0}},   {{5,0,0},{8.33,0,0},{4.99,0,0},{0,0,0}}},
            //13
            {{{25,0,0},{75,0,0},{33.33,0,0},{0,0,0}},   {{15,0,0},{85,0,0},{17.65,0,0},{0,0,0}}},
            //14
            {{{304,0,0},{38,0,0},{456,0,0},{0,0,0}},     {{270,0,0},{22.5,0,0},{630,0,0},{0,0,0}}},
            //15
            {{{8,0,0},{75,0,0},{2,0,0},{0,0,0}},   {{85,0,0},{82,0,0},{15,0,0},{0,0,0}}},
            //16
            {{{39,3,5},{40,2,5},{0,45,88},{0,0,0}},    {{17,1,2},{18,1,4},{0,45,224},{0,0,0}}},
            //17
            {{{117,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{132,0,0},{0,0,0},{0,0,0},{0,0,0}}},
            //18
            {{{4,1,4},{0,17,4},{4,3,12},{0,0,0}},     {{3,2,3},{0,11,3},{3,14,21},{0,0,0}}},
            //19
            {{{6,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{7,0,0},{0,0,0},{0,0,0},{0,0,0}}},
            //20
            {{{1600,0,0},{400,0,0},{320,0,0},{0,0,0}},    {{288,0,0},{72,0,0},{96,0,0},{0,0,0}}},
            //21
            {{{420,0,0},{379.05,0,0},{0,0,0},{0,0,0}},     {{340,0,0},{245.65,0,0},{0,0,0},{0,0,0}}},
            //22
            {{{180,0,0},{1920,0,0},{360,0,0},{0,0,0}},      {{96,0,0},{960,0,0},{192,0,0 },{0,0,0}}},
            //23
            {{{0,0,0},{0,0,0},{0,0,0},{0,0,0}},   {{0,0,0},{0,0,0},{0,0,0},{0,0,0}}}
            };

    static int [][] correct = {
            {2,3},//0
            {0,0},//1
            {0,0},//2
            {2,3},//3
            {1,3},//4
            {2,1},//5
            {3,1},//6
            {1,3},//7
            {0,0},//8
            {0,3},//9
            {1,2},//10
            {2,1},//11
            {1,3},//12
            {0,3},//13
            {0,0},//14
            {3,2},//15
            {0,2},//16
            {2,0},//17
            {3,1},//18
            {3,0},//19
            {3,2},//20
            {0,0},//21
            {0,0},//22
            {1,0},//23
            };


    static int[][] questionView = {{R.drawable.q0_0, R.drawable.q0_1},
                                    {R.drawable.q1_0, R.drawable.q1_1},
                                    {R.drawable.q2_0, R.drawable.q2_0},
                                    {R.drawable.q3_0, R.drawable.q3_1},
                                    {R.drawable.q4_0, R.drawable.q4_1},
                                    {R.drawable.q5_0, R.drawable.q5_1},
                                    {R.drawable.q6_0, R.drawable.q6_1},
                                    {R.drawable.q7_0, R.drawable.q7_1},
                                    {R.drawable.q8_0, R.drawable.q8_1},
                                    {R.drawable.q9_0, R.drawable.q9_1},
                                    {R.drawable.q10_0, R.drawable.q10_1},
                                    {R.drawable.q11_0, R.drawable.q11_1},
                                    {R.drawable.q12_0, R.drawable.q12_1},
                                    {R.drawable.q13_0, R.drawable.q13_1},
                                    {R.drawable.q14_0, R.drawable.q14_1},
                                    {R.drawable.q15_0, R.drawable.q15_1},
                                    {R.drawable.q16_0, R.drawable.q16_1},
                                    {R.drawable.q17_0, R.drawable.q17_1},
                                    {R.drawable.q18_0, R.drawable.q18_1},
                                    {R.drawable.q19_0, R.drawable.q19_1},
                                    {R.drawable.q20_0, R.drawable.q20_1},
                                    {R.drawable.q21_0, R.drawable.q21_1},
                                    {R.drawable.q22_0, R.drawable.q22_0},
                                    };
    static int [][][] answerView =
                    {{{R.drawable.a0_0_0, R.drawable.a0_0_1, R.drawable.a0_0_2, R.drawable.a0_0_3}, {R.drawable.a0_1_0, R.drawable.a0_1_1, R.drawable.a0_1_2, R.drawable.a0_1_3}},
                    {{R.drawable.a1_0_0, R.drawable.a1_0_1, R.drawable.a1_0_2, R.drawable.a1_0_3}, {R.drawable.a1_1_0, R.drawable.a1_1_1, R.drawable.a1_1_2, R.drawable.a1_1_3}},
                    {{R.drawable.a2_0_0, R.drawable.a2_0_1, R.drawable.a2_0_2, R.drawable.a2_0_3}, {R.drawable.a2_0_0, R.drawable.a2_0_1, R.drawable.a2_0_2, R.drawable.a2_0_3}},
                    {{R.drawable.a3_0_0, R.drawable.a3_0_1, R.drawable.a3_0_2, R.drawable.a3_0_3}, {R.drawable.a3_1_0, R.drawable.a3_1_1, R.drawable.a3_1_2, R.drawable.a3_1_3}},
                    {{R.drawable.a4_0_0, R.drawable.a4_0_1, R.drawable.a4_0_2, R.drawable.a4_0_3}, {R.drawable.a4_1_0, R.drawable.a4_1_1, R.drawable.a4_1_2, R.drawable.a4_1_3}},
                    {{R.drawable.a5_0_0, R.drawable.a5_0_1, R.drawable.a5_0_2, R.drawable.a5_0_3}, {R.drawable.a5_1_0, R.drawable.a5_1_1, R.drawable.a5_1_2, R.drawable.a5_1_3}},
                    {{R.drawable.a6_0_0, R.drawable.a6_0_1, R.drawable.a6_0_2, R.drawable.a6_0_3}, {R.drawable.a6_1_0, R.drawable.a6_1_1, R.drawable.a6_1_2, R.drawable.a6_1_3}},
                    {{R.drawable.a7_0_0, R.drawable.a7_0_1, R.drawable.a7_0_2, R.drawable.a7_0_3}, {R.drawable.a7_1_0, R.drawable.a7_1_1, R.drawable.a7_1_2, R.drawable.a7_1_3}},
                    {{R.drawable.a8_0_0, R.drawable.a8_0_1, R.drawable.a8_0_2, R.drawable.a8_0_3}, {R.drawable.a8_1_0, R.drawable.a8_1_1, R.drawable.a8_1_2, R.drawable.a8_1_3}},
                    {{R.drawable.a9_0_0, R.drawable.a9_0_1, R.drawable.a9_0_2, R.drawable.a9_0_3}, {R.drawable.a9_1_0, R.drawable.a9_1_1, R.drawable.a9_1_2, R.drawable.a9_1_3}},
                    {{R.drawable.a10_0_0, R.drawable.a10_0_1, R.drawable.a10_0_2, R.drawable.a10_0_3}, {R.drawable.a10_1_0, R.drawable.a10_1_1, R.drawable.a10_1_2, R.drawable.a10_1_3}},
                    {{R.drawable.a11_0_0, R.drawable.a11_0_1, R.drawable.a11_0_2, R.drawable.a11_0_3}, {R.drawable.a11_1_0, R.drawable.a11_1_1, R.drawable.a11_1_2, R.drawable.a11_1_3}},
                    {{R.drawable.a12_0_0, R.drawable.a12_0_1, R.drawable.a12_0_2, R.drawable.a12_0_3}, {R.drawable.a12_1_0, R.drawable.a12_1_1, R.drawable.a12_1_2, R.drawable.a12_1_3}},
                    {{R.drawable.a13_0_0, R.drawable.a13_0_1, R.drawable.a13_0_2, R.drawable.a13_0_3}, {R.drawable.a13_1_0, R.drawable.a13_1_1, R.drawable.a13_1_2, R.drawable.a13_1_3}},
                    {{R.drawable.a14_0_0, R.drawable.a14_0_1, R.drawable.a14_0_2, R.drawable.a14_0_3}, {R.drawable.a14_1_0, R.drawable.a14_1_1, R.drawable.a14_1_2, R.drawable.a14_1_3}},
                    {{R.drawable.a15_0_0, R.drawable.a15_0_1, R.drawable.a15_0_2, R.drawable.a15_0_3}, {R.drawable.a15_1_0, R.drawable.a15_1_1, R.drawable.a15_1_2, R.drawable.a15_1_3}},
                    {{R.drawable.a16_0_0, R.drawable.a16_0_1, R.drawable.a16_0_2, R.drawable.a16_0_3}, {R.drawable.a16_1_0, R.drawable.a16_1_1, R.drawable.a16_1_2, R.drawable.a16_1_3}},
                    {{R.drawable.a17_0_0, R.drawable.a17_0_1, R.drawable.a17_0_2, R.drawable.a17_0_3}, {R.drawable.a17_1_0, R.drawable.a17_1_1, R.drawable.a17_1_2, R.drawable.a17_1_3}},
                    {{R.drawable.a18_0_0, R.drawable.a18_0_1, R.drawable.a18_0_2, R.drawable.a18_0_3}, {R.drawable.a18_1_0, R.drawable.a18_1_1, R.drawable.a18_1_2, R.drawable.a18_1_3}},
                    {{R.drawable.a19_0_0, R.drawable.a19_0_1, R.drawable.a19_0_2, R.drawable.a19_0_3}, {R.drawable.a19_1_0, R.drawable.a19_1_1, R.drawable.a19_1_2, R.drawable.a19_1_3}},
                    {{R.drawable.a20_0_0, R.drawable.a20_0_1, R.drawable.a20_0_2, R.drawable.a20_0_3}, {R.drawable.a20_1_0, R.drawable.a20_1_1, R.drawable.a20_1_2, R.drawable.a20_1_3}},
                    {{R.drawable.a21_0_0, R.drawable.a21_0_1, R.drawable.a21_0_2, R.drawable.a21_0_3}, {R.drawable.a21_1_0, R.drawable.a21_1_1, R.drawable.a21_1_2, R.drawable.a21_1_3}},
                    {{R.drawable.a22_0_0, R.drawable.a22_0_1, R.drawable.a22_0_2, R.drawable.a22_0_3}, {R.drawable.a22_1_0, R.drawable.a22_1_1, R.drawable.a22_1_2, R.drawable.a22_1_3}}, 
                    {{R.drawable.a23_0_0, R.drawable.a23_0_1, R.drawable.a23_0_2, R.drawable.a23_0_3}, {R.drawable.a23_1_0, R.drawable.a23_1_1, R.drawable.a23_1_2, R.drawable.a23_1_3}},
                    {{R.drawable.a24_0_0, R.drawable.a24_0_1, R.drawable.a24_0_2, R.drawable.a24_0_3}, {R.drawable.a24_1_0, R.drawable.a24_1_1, R.drawable.a24_1_2, R.drawable.a24_1_3}},
                    {{R.drawable.a25_0_0, R.drawable.a25_0_1, R.drawable.a25_0_2, R.drawable.a25_0_3}, {R.drawable.a25_1_0, R.drawable.a25_1_1, R.drawable.a25_1_2, R.drawable.a25_1_3}},
                    };

    static int [][][] responseView =
                    {{{R.drawable.r0_0_0, R.drawable.r0_0_1, R.drawable.r0_0_2, R.drawable.r0_0_3}, {R.drawable.r0_1_0, R.drawable.r0_1_1, R.drawable.r0_1_2, R.drawable.r0_1_3}},
                    {{R.drawable.r1_0_0, R.drawable.r1_0_1, R.drawable.r1_0_2, R.drawable.r1_0_3}, {R.drawable.r1_1_0, R.drawable.r1_1_1, R.drawable.r1_1_2, R.drawable.r1_1_3}},
                    {{R.drawable.r2_0_0, R.drawable.r2_0_0, R.drawable.r2_0_0, R.drawable.r2_0_0}, {R.drawable.r2_0_0, R.drawable.r2_0_0, R.drawable.r2_0_0, R.drawable.r2_0_0}},
                    {{R.drawable.r3_0_0, R.drawable.r3_0_1, R.drawable.r3_0_2, R.drawable.r3_0_3}, {R.drawable.r3_1_0, R.drawable.r3_1_1, R.drawable.r3_1_2, R.drawable.r3_1_3}},
                    {{R.drawable.r4_0_0, R.drawable.r4_0_1, R.drawable.r4_0_2, R.drawable.r4_0_3}, {R.drawable.r4_1_0, R.drawable.r4_1_1, R.drawable.r4_1_2, R.drawable.r4_1_3}},
                    {{R.drawable.r5_0_0, R.drawable.r5_0_1, R.drawable.r5_0_2, R.drawable.r5_0_3}, {R.drawable.r5_1_0, R.drawable.r5_1_1, R.drawable.r5_1_2, R.drawable.r5_1_3}},
                    {{R.drawable.r6_0_0, R.drawable.r6_0_1, R.drawable.r6_0_2, R.drawable.r6_0_3}, {R.drawable.r6_1_0, R.drawable.r6_1_1, R.drawable.r6_1_2, R.drawable.r6_1_3}},
                    {{R.drawable.r7_0_0, R.drawable.r7_0_1, R.drawable.r7_0_2, R.drawable.r7_0_3}, {R.drawable.r7_1_0, R.drawable.r7_1_1, R.drawable.r7_1_2, R.drawable.r7_1_3}},
                    {{R.drawable.r8_0_0, R.drawable.r8_0_1, R.drawable.r8_0_2, R.drawable.r8_0_3}, {R.drawable.r8_1_0, R.drawable.r8_1_1, R.drawable.r8_1_2, R.drawable.r8_1_3}},
                    {{R.drawable.r9_0_0, R.drawable.r9_0_1, R.drawable.r9_0_2, R.drawable.r9_0_3}, {R.drawable.r9_1_0, R.drawable.r9_1_1, R.drawable.r9_1_2, R.drawable.r9_1_3}},
                    {{R.drawable.r10_0_0, R.drawable.r10_0_1, R.drawable.r10_0_2, R.drawable.r10_0_3}, {R.drawable.r10_1_0, R.drawable.r10_1_1, R.drawable.r10_1_2, R.drawable.r10_1_3}},
                    {{R.drawable.r11_0_0, R.drawable.r11_0_1, R.drawable.r11_0_2, R.drawable.r11_0_3}, {R.drawable.r11_1_0, R.drawable.r11_1_1, R.drawable.r11_1_2, R.drawable.r11_1_3}},
                    {{R.drawable.r12_0_0, R.drawable.r12_0_1, R.drawable.r12_0_2, R.drawable.r12_0_3}, {R.drawable.r12_1_0, R.drawable.r12_1_1, R.drawable.r12_1_2, R.drawable.r12_1_3}},
                    {{R.drawable.r13_0_0, R.drawable.r13_0_1, R.drawable.r13_0_2, R.drawable.r13_0_3}, {R.drawable.r13_1_0, R.drawable.r13_1_1, R.drawable.r13_1_2, R.drawable.r13_1_3}},
                    {{R.drawable.r14_0_0, R.drawable.r14_0_1, R.drawable.r14_0_2, R.drawable.r14_0_3}, {R.drawable.r14_1_0, R.drawable.r14_1_1, R.drawable.r14_1_2, R.drawable.r14_1_3}},
                    {{R.drawable.r15_0_0, R.drawable.r15_0_1, R.drawable.r15_0_2, R.drawable.r15_0_3}, {R.drawable.r15_1_0, R.drawable.r15_1_1, R.drawable.r15_1_2, R.drawable.r15_1_3}},
                    {{R.drawable.r16_0_0, R.drawable.r16_0_1, R.drawable.r16_0_2, R.drawable.r16_0_3}, {R.drawable.r16_1_0, R.drawable.r16_1_1, R.drawable.r16_1_2, R.drawable.r16_1_3}},
                    {{R.drawable.r17_0_0, R.drawable.r17_0_1, R.drawable.r17_0_2, R.drawable.r17_0_3}, {R.drawable.r17_1_0, R.drawable.r17_1_1, R.drawable.r17_1_2, R.drawable.r17_1_3}},
                    {{R.drawable.r18_0_0, R.drawable.r18_0_1, R.drawable.r18_0_2, R.drawable.r18_0_3}, {R.drawable.r18_1_0, R.drawable.r18_1_1, R.drawable.r18_1_2, R.drawable.r18_1_3}},
                    {{R.drawable.r19_0_0, R.drawable.r19_0_1, R.drawable.r19_0_2, R.drawable.r19_0_3}, {R.drawable.r19_0_0, R.drawable.r19_0_1, R.drawable.r19_0_2, R.drawable.r19_0_3}},
                    {{R.drawable.r20_0_0, R.drawable.r20_0_1, R.drawable.r20_0_2, R.drawable.r20_0_3}, {R.drawable.r20_1_0, R.drawable.r20_1_1, R.drawable.r20_1_2, R.drawable.r20_1_3}},
                    {{R.drawable.r21_0_0, R.drawable.r21_0_1, R.drawable.r21_0_2, R.drawable.r21_0_3}, {R.drawable.r21_1_0, R.drawable.r21_1_1, R.drawable.r21_1_2, R.drawable.r21_1_3}},
                    {{R.drawable.r22_0_0, R.drawable.r22_0_0, R.drawable.r22_0_0, R.drawable.r22_0_0}, {R.drawable.r22_0_0, R.drawable.r22_0_0, R.drawable.r22_0_0, R.drawable.r22_0_0}},
                    //{{R.drawable.r23_0_0, R.drawable.r23_0_0, R.drawable.r23_0_0, R.drawable.r23_0_0}, {R.drawable.r23_0_0, R.drawable.r23_0_0, R.drawable.r23_0_0, R.drawable.r23_0_0}}
                    };


    static int [][][] audioFile = {{{R.raw.v0_0_0, R.raw.v0_0_1, R.raw.v0_0_2, R.raw.v0_0_3},{R.raw.v0_1_0, R.raw.v0_1_1, R.raw.v0_1_2, R.raw.v0_1_3}},
            {{R.raw.v1_0_0, R.raw.v1_0_1, R.raw.v1_0_2, R.raw.v1_0_3}, {R.raw.v1_1_0, R.raw.v1_1_1, R.raw.v1_1_2, R.raw.v1_1_3}},
            {{R.raw.v2_0_0, R.raw.v2_0_0, R.raw.v2_0_0, R.raw.v2_0_0}, {R.raw.v2_0_0, R.raw.v2_0_0, R.raw.v2_0_0, R.raw.v2_0_0}},
            {{R.raw.v3_0_0, R.raw.v3_0_1, R.raw.v3_0_2, R.raw.v3_0_3}, {R.raw.v3_1_0, R.raw.v3_1_1, R.raw.v3_1_2, R.raw.v3_1_3}},
            {{R.raw.v4_0_0, R.raw.v4_0_1, R.raw.v4_0_2, R.raw.v4_0_3}, {R.raw.v4_1_0, R.raw.v4_1_1, R.raw.v4_1_2, R.raw.v4_1_3}},
            {{R.raw.v5_0_0, R.raw.v5_0_1, R.raw.v5_0_2, R.raw.v5_0_3}, {R.raw.v5_1_0, R.raw.v5_1_1, R.raw.v5_1_2, R.raw.v5_1_3}},
            {{R.raw.v6_0_0, R.raw.v6_0_1, R.raw.v6_0_2, R.raw.v6_0_3}, {R.raw.v6_1_0, R.raw.v6_1_1, R.raw.v6_1_2, R.raw.v6_1_3}},
            {{R.raw.v7_0_0, R.raw.v7_0_1, R.raw.v7_0_2, R.raw.v7_0_3}, {R.raw.v7_1_0, R.raw.v7_1_1, R.raw.v7_1_2, R.raw.v7_1_3}},
            {{R.raw.v8_0_0, R.raw.v8_0_1, R.raw.v8_0_2, R.raw.v8_0_3}, {R.raw.v8_1_0, R.raw.v8_1_1, R.raw.v8_1_2, R.raw.v8_1_3}},
            {{R.raw.v9_0_0, R.raw.v9_0_1, R.raw.v9_0_2, R.raw.v9_0_3}, {R.raw.v9_1_0, R.raw.v9_1_1, R.raw.v9_1_2, R.raw.v9_1_3}},
            {{R.raw.v10_0_0, R.raw.v10_0_1, R.raw.v10_0_2, R.raw.v10_0_3}, {R.raw.v10_1_0, R.raw.v10_1_1, R.raw.v10_1_2, R.raw.v10_1_3}},
            {{R.raw.v11_0_0, R.raw.v11_0_1, R.raw.v11_0_2, R.raw.v11_0_3}, {R.raw.v11_1_0, R.raw.v11_1_1, R.raw.v11_1_2, R.raw.v11_1_3}},
            {{R.raw.v12_0_0, R.raw.v12_0_1, R.raw.v12_0_2, R.raw.v12_0_3}, {R.raw.v12_1_0, R.raw.v12_1_1, R.raw.v12_1_2, R.raw.v12_1_3}},
            {{R.raw.v13_0_0, R.raw.v13_0_1, R.raw.v13_0_2, R.raw.v13_0_3}, {R.raw.v13_1_0, R.raw.v13_1_1, R.raw.v13_1_2, R.raw.v13_1_3}},
            {{R.raw.v14_0_0, R.raw.v14_0_1, R.raw.v14_0_2, R.raw.v14_0_3}, {R.raw.v14_1_0, R.raw.v14_1_1, R.raw.v14_1_2, R.raw.v14_1_3}},
            {{R.raw.v15_0_0, R.raw.v15_0_1, R.raw.v15_0_2, R.raw.v15_0_3}, {R.raw.v15_1_0, R.raw.v15_1_1, R.raw.v15_1_2, R.raw.v15_1_3}},
            {{R.raw.v16_0_0, R.raw.v16_0_1, R.raw.v16_0_2, R.raw.v16_0_3}, {R.raw.v16_1_0, R.raw.v16_1_1, R.raw.v16_1_2, R.raw.v16_1_3}},
            {{R.raw.v17_0_0, R.raw.v17_0_1, R.raw.v17_0_2, R.raw.v17_0_3}, {R.raw.v17_1_0, R.raw.v17_1_1, R.raw.v17_1_2, R.raw.v17_1_3}},
            {{R.raw.v18_0_0, R.raw.v18_0_1, R.raw.v18_0_2, R.raw.v18_0_3}, {R.raw.v18_1_0, R.raw.v18_1_1, R.raw.v18_1_2, R.raw.v18_1_3}},
            {{R.raw.v19_0_0, R.raw.v19_0_1, R.raw.v19_0_2, R.raw.v19_0_3}, {R.raw.v19_0_0, R.raw.v19_0_1, R.raw.v19_0_2, R.raw.v19_0_3}},
            {{R.raw.v20_0_0, R.raw.v20_0_1, R.raw.v20_0_2, R.raw.v20_0_3}, {R.raw.v20_1_0, R.raw.v20_1_1, R.raw.v20_1_2, R.raw.v20_1_3}},
            {{R.raw.v21_0_0, R.raw.v21_0_1, R.raw.v21_0_2, R.raw.v21_0_3}, {R.raw.v21_1_0, R.raw.v21_1_1, R.raw.v21_1_2, R.raw.v21_1_3}},
            {{R.raw.v22_0_0, R.raw.v22_0_0, R.raw.v22_0_0, R.raw.v22_0_0}, {R.raw.v22_0_0, R.raw.v22_0_0, R.raw.v22_0_0, R.raw.v22_0_0}},
            //{{R.raw.v23, R.raw.v23, R.raw.v23, R.raw.v23}, {R.raw.v23, R.raw.v23, R.raw.v23, R.raw.v23}}
    };

}

