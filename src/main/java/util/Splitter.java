package util;

import lotto.domain.LottoNumber;
import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    private static final String COMMA = ",";
    private static final List<Number> numbers = new ArrayList<>();

    public static List<Number> SplitStringNumbers(String inputPrizeNumbers) {
        numbers.clear();
        String[] numbers = inputPrizeNumbers.trim().split(COMMA);
        validateInputNumber(numbers);
        return createWinnerNumbers(numbers);
    }

    private static void validateInputNumber(String[] numbers) {
        if(numbers.length != CommonConstants.NUMBER_LENGTH_MAX) {
            CommonException.IllegalArgumentException(Message.NUMBER_LENGTH_EXCESS);
        }
    }

    private static List<Number> createWinnerNumbers(String[] arrayNumber) {
        Arrays.stream(arrayNumber)
                .mapToInt(Integer::parseInt)
                .forEach(number -> numbers.add(LottoNumber.of(number)));
        return numbers;
    }
}
