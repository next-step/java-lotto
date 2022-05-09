package lotto.util;

import lotto.exception.InvalidInputLottoNumberException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {

    private static final String INVALID_READ_MONEY_ERROR_MESSAGE = "구매 금액을 제대로 입력해주세요.";
    private static final String DELIMITER = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static BigDecimal readMoney(String input) {
        return BigDecimal.valueOf(parseLong(input));
    }

    public static List<Integer> readLottoNumbers(String input) {
        String replacedString = input.replaceAll(" ", "");
        return getLottoNumbers(replacedString);
    }

    public static Integer readBonusNumber(String input) {
        return getInteger(input);
    }

    private static Integer getInteger(String input) {
        int integer;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
        return integer;
    }

    private static List<Integer> getLottoNumbers(String input) {
        String[] split = splitInputByDelimiter(input);
        return convertNumbers(split);
    }

    private static String[] splitInputByDelimiter(String input) {
        return input.split(DELIMITER);
    }

    private static List<Integer> convertNumbers(String[] split) {
        List<Integer> collect;
        collect = Arrays.stream(split)
                .map(InputUtil::getInteger)
                .collect(Collectors.toList());
        validLottoNumbers(collect);
        return collect;
    }

    private static void validLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidInputLottoNumberException();
        }
    }

    private static long parseLong(String input) {
        long longValue;
        try {
            longValue = Long.parseLong(input);
        } catch (RuntimeException e) {
            throw new NumberFormatException(INVALID_READ_MONEY_ERROR_MESSAGE);
        }
        return longValue;
    }
}
