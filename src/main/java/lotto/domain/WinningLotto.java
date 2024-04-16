package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.parser.LottoNumberParser;

import java.util.List;

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
        return LottoNumberParser.parse(winningNumbers);
    }

    public Integer compareLotto(Lotto comparedLotto) {
        return (int) this.winningLotto.stream().filter(comparedLotto::containNumber).count();
    }

    public Boolean isBonusIncluded(Lotto comparedLotto) {
        return comparedLotto.containNumber(bonusNumber);
    }
}
