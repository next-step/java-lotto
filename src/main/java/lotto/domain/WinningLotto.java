package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<Integer> winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static List<Integer> getWinningNumbers(String winningNumbers) {
        List<Integer> parseWinningNumbers = parseWinningNumbers(winningNumbers);
        Lotto.validateNumbers(parseWinningNumbers);

        return parseWinningNumbers;
    }

    public static Integer getBonusNumber(String bonusNumber) {
        int parsedBonusNumber;

        try {
            parsedBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NUMERIC_ERROR.getMessage());
        }

        Lotto.validateLottoNumberBound(parsedBonusNumber);

        return parsedBonusNumber;
    }

    public List<Integer> getLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private static List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(
                    winningNumbers.replaceAll("\\s", "").split(",")
            ).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NUMERIC_ERROR.getMessage());
        }
    }

    public Integer compareLotto(Lotto comparedLotto) {
        return (int) this.winningLotto.stream().filter(comparedLotto.getLottoNumbers()::contains).count();
    }

    public Boolean isBonusIncluded(Lotto comparedLotto) {
        return comparedLotto.getLottoNumbers().contains(bonusNumber);
    }
}
