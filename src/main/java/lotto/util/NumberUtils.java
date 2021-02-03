package lotto.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {

    private static final int FIRST_RANGE_LOTTO_NUMBER = 1;
    private static final int END_RANGE_LOTTO_NUMBER = 45;
    private static final String COMMA = ", ";

    public static Integer returnInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double calculateYield(int inputPrice, int income) {
        BigDecimal bd = new BigDecimal((double) income / inputPrice);
        return bd.setScale(2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    public static boolean isNumberUnique(List<String> numbers) {
        return numbers
            .stream()
            .distinct()
            .count() == numbers.size();
    }

    public static boolean isNumberInLottoRange(List<String> numbers) {
        return numbers
            .stream()
            .map(Integer::parseInt)
            .allMatch(NumberUtils::checkLottoNumber);
    }

    public static boolean checkLottoNumber(int num) {
        return FIRST_RANGE_LOTTO_NUMBER <= num && num <= END_RANGE_LOTTO_NUMBER;
    }

    public static List<Integer> convertStringToIntegerList(String winningNumber) {
        return Arrays.stream(winningNumber.split(COMMA))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int convertNullToNumber(Integer value) {
        if (value == null) {
            return 0;
        }
        return value;
    }
}
