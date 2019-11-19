package step2.numbers;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InputNumbersUtil {
    private static final String NUMBER_COUNT_EXCEPTION = "입력된 로또번호가 6개가 아닙니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "로또번호는 중복된 숫자를 허용하지 않습니다.";
    private static final String DELIMITER = ",";

    public static List<Number> toNumberList(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER))
                .map(num -> Integer.parseInt(num.trim()))
                .map(Number::valueOf).collect(toList());
    }

    public static void verifyLottoNumberCount(List<Number> inputWinningNumbers) {
        if (inputWinningNumbers.size() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION);
        }
        if (inputWinningNumbers.stream().distinct().count() != LottoGame.NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
        }
    }
}
