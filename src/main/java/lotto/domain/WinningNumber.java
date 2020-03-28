package lotto.domain;

import java.util.List;

public class WinningNumber extends LottoNumber {
    private final BonusNumber bonusNumber;

    public WinningNumber(List<Integer> lottoNumber, int bonusNumber) {
        super(lottoNumber);
        this.bonusNumber = new BonusNumber(lottoNumber, bonusNumber);
    }

    public boolean isMatchBonusNumber(LottoNumber winningNumber) {
        return winningNumber.getLottoNumber()
                .stream()
                .filter(this::isMatchBonusNumber)
                .count() == 1;
    }

    private boolean isMatchBonusNumber(int number) {
        return bonusNumber.equals(number);
    }
}
