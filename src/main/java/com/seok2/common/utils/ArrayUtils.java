package com.seok2.common.utils;

public class ArrayUtils {

    private static final int ZERO = 0;

    private ArrayUtils() {
    }

    public static boolean isEmpty(int [] arr) {
        return arr == null || arr.length == ZERO;
    }

}
