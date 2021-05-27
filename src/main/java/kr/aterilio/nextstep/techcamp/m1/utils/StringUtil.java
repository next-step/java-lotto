package kr.aterilio.nextstep.techcamp.m1.utils;

public class StringUtil {

    public static Integer[] convertToIntegerArray(String[] targets) {
        Integer[] convert = new Integer[targets.length];
        for (int i = targets.length-1; i >= 0; --i) {
            convert[i] = Integer.parseInt(targets[i].trim());
        }
        return convert;
    }
}
