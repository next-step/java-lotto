package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStringUtil {

    private LottoStringUtil() {
    }

    public static List<Integer> splitStringToIntegerList(String numberString) {
        return Arrays.stream(numberString.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static List<Integer> parseToIntegerList(List<String> stringList) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringList) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

}
