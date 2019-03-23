package lotto.vo;

import lotto.domain.Lotto;

import java.util.List;

public class LottoWinningNumber {
    private Lotto winningNumber;

    private LottoNo bonusNumber;

    public LottoWinningNumber(Lotto winningNumber, LottoNo bonusNumber) throws IllegalArgumentException {
        //보너스번호 중복 체크
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호 중복됨");
        }

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> checkWinningNumber(List<Lotto> lottos) {
        winningNumber.getNumbers()
                .forEach(number -> checkWinningNumber(lottos, number));

        return lottos;
    }

    public void checkWinningNumber(List<Lotto> lottos, LottoNo number) {
        lottos.forEach(lotto -> lotto.incrementMatchCount(number));
    }

    public void checkBonus(List<Lotto> lottos) {
        lottos.forEach(lotto -> lotto.checkBonus(bonusNumber));
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }
}
