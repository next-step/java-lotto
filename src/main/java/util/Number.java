package util;

public class Number {

    public static Integer[] rangeNumber(int startNumber , int endNumber) {
        Integer[] result = new Integer[endNumber];
        for (int i = 0; i < endNumber; i++) {
            result[i] = startNumber + i;
        }
        return result;
    }
}
