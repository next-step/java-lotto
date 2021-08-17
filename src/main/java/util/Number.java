package util;

public class Number {

    public static Integer[] rangeNumber(int startNumber , int endNumber) {
        Integer[] result = new Integer[endNumber];
        for (int i = 0; i < endNumber; i++) {
            result[i] = startNumber + i;
        }
        return result;
    }

    public static Integer[] stringArrayToInteger(String[] stringArray) {
        Integer[] result = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = Integer.parseInt(stringArray[i]);
        }
        return result;
    }
}
