package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoStringUtil {

    private LottoStringUtil() {
    }

    public static List<String> splitString(String numberString) {
        return Arrays.asList(numberString.split(","));
    }

    public static List<Integer> parseToIntegerList(List<String> stringList) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringList) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

}
