package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<Integer> winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        List<Integer> parsedWInningNumbers = parseWinningNumbers(winningNumbers);
        Lotto.validateNumbers(parsedWInningNumbers);

        this.winningLotto = parseWinningNumbers(winningNumbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getLotto() {
        return winningLotto;
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
        return (int) this.winningLotto.stream().filter(comparedLotto.getLotto()::contains).count();
    }
}
