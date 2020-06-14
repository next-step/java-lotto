package step2.util;

import static step2.Constants.COMMA;
import static step2.Constants.EMPTY_STRING;
import static step2.Constants.REX_WHITE_SPACE_IN_STRING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<Integer> convertStringToIntegerList(List<String> stringList) {
        List<Integer> result = new ArrayList<>();
        try {
            stringList.forEach(string -> result.add(Integer.parseInt(string)));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }


    public static List<String> convertCsvStringToList(String csvString)
        throws IllegalArgumentException {

        String[] parsedCsvString = csvString
            .replaceAll(REX_WHITE_SPACE_IN_STRING, EMPTY_STRING)
            .split(COMMA);

        return Arrays.asList(parsedCsvString);
    }
}
