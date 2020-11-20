package my.project.utils;

import my.project.constants.Delimiters;

/**
 * Created : 2020-11-20 오후 12:35
 * Developer : Seo
 */
public class ArrayUtils {

    public static boolean isStringAlone(String input) {
        String[] arr = input.split(Delimiters.DELIMITER);
        return arr.length == 1;
    }

    private ArrayUtils() {}
}
