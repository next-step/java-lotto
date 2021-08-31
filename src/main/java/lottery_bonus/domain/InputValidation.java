package lottery_bonus.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputValidation {

    private static final String VALIDATION_ERROR_MESSAGE = "숫자를 입력해주세요";

    public static BigDecimal validateAmount(final String amount) {
        validateInputNumber(amount);
        return new BigDecimal(amount);
    }

    public static List<Integer> validateWinningNumber(final String winningNumbers){
        validateInputWinningNumber(winningNumbers);

        return Arrays.stream(winningNumbers.split(", "))
                .map(winningNumber -> parseInteger(winningNumber))
                .collect(Collectors.toList());

    }

    public static int parseInteger(final String bonusNumber) {
        validateInputNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateInputNumber(final String amount){
        if(!amount.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException(VALIDATION_ERROR_MESSAGE);
        };
    }

    private static void validateInputWinningNumber(final String winningNumber){
        if(winningNumber.isEmpty() || winningNumber == null){
            throw new IllegalArgumentException("");
        }
    }
}
