package utils;

import java.util.*;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }
        String[] splitText = StringUtils.splitString(text);
        List<Integer> intArray = convertToIntArray(splitText);
        return sumIntArray(intArray);
    }

    private static List<Integer> convertToIntArray(String[] stringArray) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringArray) {
            intList.add(convertUnsignedInt(s));
        }
        return intList;
    }

    public static Set<Integer> convertToIntSet(String[] stringArray) {
        Set<Integer> intList = new TreeSet<>();
        for (String s : stringArray) {
            intList.add(convertUnsignedInt(s));
        }
        return intList;
    }

    private static int convertUnsignedInt(String text) {
        int integer = Integer.parseInt(text);
        if (integer < 0) {
            throw new RuntimeException("you input negative Integer : " + text);
        }
        return integer;
    }

    private static int sumIntArray(List<Integer> intArray) {
        int sum = 0;
        for (int value : intArray) {
            sum += value;
        }
        return sum;
    }
}
