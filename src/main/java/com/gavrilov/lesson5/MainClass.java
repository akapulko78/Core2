package com.gavrilov.lesson5;

public class MainClass {
    static final int size = 10_000_000;
    static final int h = size / 2;

    static void method1() {
        float[] arr = new float[size];
        for (float v : arr) {
            v = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    static void method2() {
        float[] arr = new float[size];
        for (float v : arr) {
            v = 1;
        }
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        for (int i = 0; i < a1.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < a2.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    static class TimeChecker implements Runnable {

        @Override
        public void run() {
            method2();
        }
    }


    public static void main(String[] args) {
        method1();
        new Thread(new TimeChecker()).start();
        new Thread(new TimeChecker()).start();

    }

}
