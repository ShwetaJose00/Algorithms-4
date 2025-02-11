package edu.neu.coe.info6205.sort.par;

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

/**
 * This code has been fleshed out by Ziyao Qiao. Thanks very much.
 * TODO tidy it up a bit.
 */
public class Main {


    public static void main(String[] args) {


        //Executor executor = Executors.newFixedThreadPool(32);
        processArgs(args);
        //System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        //System.out.println("Degree of parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        //int thread = 2;
        //while(thread<=32) {
            //for(int i = 2; i<=128; i^=2){
            //thread = i;
            threadCount.demo(2);

            //thread = 2*thread;
        //}
        //}


        /*
        Random random = new Random();
        int[] array = new int[2000000]; //500000 ///original size -> 2000000
        ArrayList<Long> timeList = new ArrayList<>();
        //for (int j = 55; j < 75; j++) { // j = 50, j<100

            ParSort.cutoff = 670000; ///original cutoff formula -> 10000 * (j + 1)   //increase the cuttoff value by 5000; use a for loop until that loops 10 times
            // for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
            long time;
            long startTime = System.currentTimeMillis();

            for (int t = 0; t < 10; t++) {
                for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000000);
                ParSort.sort(array, 0, array.length);
            }
            long endTime = System.currentTimeMillis();
            time = (endTime - startTime);
            timeList.add(time);


            System.out.println("cutoff：" + (ParSort.cutoff) + "\t\t10times Time: " + time + " ms " + "\t\tThread Count: " + threadCount);

            //} /////////////// need to get this back
        */


        /*
        try {
            FileOutputStream fis = new FileOutputStream("./src/result.csv");
            OutputStreamWriter isr = new OutputStreamWriter(fis);
            BufferedWriter bw = new BufferedWriter(isr);
            int j = 0;
            for (long i : timeList) {
                String content = (double) 10000 * (j + 1) / 2000000 + "," + (double) i / 10 + "\n";
                j++;
                bw.write(content);
                bw.flush();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }



    private static void processArgs(String[] args) {
        String[] xs = args;
        while (xs.length > 0)
            if (xs[0].startsWith("-")) xs = processArg(xs);
    }

    private static String[] processArg(String[] xs) {
        String[] result = new String[0];
        System.arraycopy(xs, 2, result, 0, xs.length - 2);
        System.out.println(xs[0]); ////////////
        processCommand(xs[0], xs[1]);
        return result;
    }

    private static void processCommand(String x, String y) {
        if (x.equalsIgnoreCase("N")) setConfig(x, Integer.parseInt(y));
        else
            // TODO sort this out
            if (x.equalsIgnoreCase("P")) //noinspection ResultOfMethodCallIgnored
                ForkJoinPool.getCommonPoolParallelism();
    }

    private static void setConfig(String x, int i) {
        configuration.put(x, i);
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private static final Map<String, Integer> configuration = new HashMap<>();


}
