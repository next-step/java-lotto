package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private LottoParser() {
    }

    // 지난 주 당첨 번호 입력받기
    public static List<Integer> parseWinningNumbers(String winningNumbersInput) {
        LottoInputValidator.validateInputString(winningNumbersInput);
        return Arrays.stream(winningNumbersInput.split(LottoInputValidator.WINNING_NUMBERS_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}
