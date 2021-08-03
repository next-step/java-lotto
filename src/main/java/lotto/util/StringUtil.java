package lotto.util;

import java.util.LinkedList;
import java.util.List;

public class StringUtil {
    private static final String SEPARATOR = ", |,";
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    private StringUtil() {}

    public static String[] separator(String inputString){
        return inputString.split(SEPARATOR);
    }

    public static List<Integer> stringArrayToIntegerList(String[] inputStringArray) {
        List<Integer> integerList = new LinkedList<>();
        for (String inputString : inputStringArray) {
            checkDupleNumber(inputString,integerList);
            integerList.add(Integer.parseInt(inputString));
        }
        checkInputNumberCount(integerList);
        return integerList;
    }

    private static void checkInputNumberCount(List<Integer> integerList) {
        if (integerList.size() != LOTTO_NUMBER_MAX_COUNT) {
            throw new IllegalArgumentException("6개 번호를 입력하세요.");
        }
    }

    private static void checkDupleNumber(String inputString, List<Integer> integerList) {
        if (integerList.contains(Integer.parseInt(inputString))) {
            throw new IllegalArgumentException("중복된 번호를 입력했습니다.");
        }
    }
}
