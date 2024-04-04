package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {
    public WinningLotto(String winningNumbers) {
        super(parseWinningNumbers(winningNumbers));
    }

    private static List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(
                    winningNumbers.replaceAll("\\s", "").split(",")
            ).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NUMERIC_ERROR);
        }
    }

    public Integer compareLotto(Lotto comparedLotto) {
        return (int) this.getLotto().stream().filter(comparedLotto.getLotto()::contains).count();
    }
}
