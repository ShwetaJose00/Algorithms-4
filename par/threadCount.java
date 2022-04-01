package edu.neu.coe.info6205.sort.par;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class threadCount {
    public static void demo(int thread) {

        //for (int size = 4000; size<=2000000; size=100){
            Random random = new Random();
            int[] array = new int[4000000]; //500000 ///original size -> 2000000
            ArrayList<Long> timeList = new ArrayList<>();
            for (int j = 0; j < 115000; j+=5000) { // j = 50, j<100

            ParSort.cutoff = 5000+ j; ///original cutoff formula -> 10000 * (j + 1)   //increase the cuttoff value by 5000; use a for loop until that loops 10 times
            for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
            long time;
            long startTime = System.currentTimeMillis();

            for (int t = 0; t < 10; t++) {
                for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
                ParSort.sort(array, 0, array.length, thread);
            }

            long endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            timeList.add(time);

            BigDecimal bd = new BigDecimal((ParSort.cutoff)/100000).setScale(2, RoundingMode.HALF_UP);
            double newInput = bd.doubleValue();


            System.out.println(newInput + "\t " + time + "\t " +thread);
            //System.out.println("cutoff：" + newInput + "\t\t10times Time: " + time + " ms " + "\t\tNumber of parallel sorts: " + thread + "\t\tArray size: " + size);
        }
    }
}
