package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        validateWinningNumberRange();
        validateWinningNumbersSize();
    }

    public static WinningNumbers from(Lotto winningNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public boolean isWinningNumbersContain (LottoNumber number) {
        return number.isInLottoNumberList(winningNumbers.getLotto());
    }

    public boolean isBonusNumberContain (LottoNumber number) {
        return bonusNumber.isEqualTo(number);
    }

    private void validateWinningNumberRange() {
        if (!isWinningNumberInRange()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 이상 45 이하로 입력해주세요.");
        }
    }

    private void validateWinningNumbersSize() {
        if (winningNumbers.getLotto().size() != Lotto.LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 개수는 6개로 입력해주세요.");
        }
    }

    private boolean isWinningNumberInRange() {
        List<Integer> validLottoNumber = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        return winningNumbers.getLotto().stream()
            .allMatch(winningNumber -> winningNumber.isInList(validLottoNumber));
    }
}
