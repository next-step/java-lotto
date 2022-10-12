package lotto.validator;

import lotto.models.request.WinningLottoRequest;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WinningLottoRequestValidator {

    private static final String STRING_NUMBER_WRONG_CHARACTER = "문자열로 입력된 로또 번호는 숫자, 공백, 콤마(,)만을 포함해야합니다.";
    private static final String WRONG_BONUS_NUMBER = "로또 번호는 반드시 1~45의 값 입니다.";
    private static final String DUPLICATED_BONUS_NUMBER = "보너스 번호와 로또 번호는 중복되지 않아야합니다.";
    private static final Pattern COMMON_SEPARATOR_PATTERN = Pattern.compile("^[0-9,\\s]*$");

    private WinningLottoRequestValidator() {
    }

    public static void validate(WinningLottoRequest winningLottoRequest) {
        if (!COMMON_SEPARATOR_PATTERN.matcher(winningLottoRequest.getWinningNumber()).matches()) {
            throw new IllegalArgumentException(STRING_NUMBER_WRONG_CHARACTER);
        }

        if (winningLottoRequest.getBonusNumber() < 1 || winningLottoRequest.getBonusNumber() > 45) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER);
        }

        if (bonusNumberIsDuplicated(winningLottoRequest)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER);
        }
    }

    private static boolean bonusNumberIsDuplicated(WinningLottoRequest winningLottoRequest) {
        String[] winningNumbers = winningLottoRequest.getWinningNumber().split(",");
        return Arrays.stream(winningNumbers).anyMatch(number -> Integer.parseInt(number.trim()) == winningLottoRequest.getBonusNumber());
    }
}
