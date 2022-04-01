package edu.neu.coe.info6205.sort.par;
import java.util.Random;

public class Driver {
    public static void main(String[] args){
        Random random = new Random();
        int[] array = new int[16];

        ParSort.cutoff = 8;
        System.out.println("\nArray length:" + array.length);
        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(100);


        System.out.println("\nBefore sorting:\n ");
        for (int i = 0; i < array.length; i++) System.out.println("Next element " + array[i]);

        System.out.println("\nArray length:" + array.length);
        //ParSort.sort(array, 0, array.length, executor);

        System.out.println("\nAfter sorting:\n ");
        for (int i = 0; i < array.length; i++) System.out.println(array[i]);
    }
}
