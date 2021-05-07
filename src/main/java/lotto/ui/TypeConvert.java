package lotto.ui;

import java.util.ArrayList;
import java.util.List;

public class TypeConvert {
    public static String STRING_SEPARATOR = ",";

    public static List<Integer> convertStringListToIntegerList(List<String> stringList) {
        List<Integer> convertedList = new ArrayList<>();
        for (String element : stringList) {
            convertedList.add(Integer.parseInt(element));
        }
        return convertedList;
    }

    public static List<String> convertStringToStringList(String string) {
        List<String> convertedList = new ArrayList<>();
        for (String element : string.split(STRING_SEPARATOR)) {
            convertedList.add(element);
        }
        return convertedList;
    }

    public static Integer convertStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
