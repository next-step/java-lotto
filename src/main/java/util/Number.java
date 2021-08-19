package util;

import java.util.Arrays;
import java.util.List;

public class Number {

    public static List<Integer> rangeNumber(int startNumber , int endNumber) {
        Integer[] result = new Integer[endNumber];
        for (int i = 0; i < endNumber; i++) {
            result[i] = startNumber + i;
        }
        return Arrays.asList(result);
    }

    public static List<Integer> stringArrayToIntegerList(List<String> stringArray) {
        Integer[] result = new Integer[stringArray.size()];
        for (int i = 0; i < stringArray.size(); i++) {
            result[i] = Integer.parseInt(stringArray.get(i));
        }
        return Arrays.asList(result);
    }
}
