package lotto.util;

public class Utility {
    private static final String DELIMETER = ", ";

    public static String[] split(String lotto) {
        return lotto.split(DELIMETER);
    }

    public static Integer[] convertStringArrayToIntegerArray(String[] stringArray) {
        Integer[] integerArray = new Integer[stringArray.length];
        for (int i = 0, len = stringArray.length; i < len; i++) {
            integerArray[i] = Integer.parseInt(stringArray[i]);
        }
        return integerArray;
    }

    public static boolean checkNumberRange(int number, int minNumber, int maxNumber) {
        return (number < minNumber) || (number > maxNumber);
    }
}
