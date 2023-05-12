package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private LottoParser() {
    }

    // 지난 주 당첨 번호 입력받기
    public static LottoNumber parseWinningNumbers(String winningNumbersInput) {
        LottoInputValidator.validateInputString(winningNumbersInput);
        List<Integer> lottoNumbers = Arrays.stream(winningNumbersInput.split(LottoInputValidator.WINNING_NUMBERS_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return new LottoNumber(lottoNumbers);
    }
}
