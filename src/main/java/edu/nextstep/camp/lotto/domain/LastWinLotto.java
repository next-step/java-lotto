package edu.nextstep.camp.lotto.domain;

public class LastWinLotto {

    private final Lotto lastWinLotto;

    private final LottoNumber bonusNumber;

    public LastWinLotto(Lotto lastWinLotto, LottoNumber bonusNumber) {
        duplicateBonusNumberCheck(lastWinLotto, bonusNumber);

        this.lastWinLotto = lastWinLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkRank(Lotto lotto) {
        return LottoRank.valueOf(lotto.matchNumberCount(lastWinLotto), lotto.isMatchBonus(bonusNumber));
    }

    private static void duplicateBonusNumberCheck(Lotto lastWinLotto, LottoNumber bonusNumber) {
        if (lastWinLotto.contains(bonusNumber)){
            throw new IllegalArgumentException("보너스 번호는 지난주 로또 번호와 겹칠 수 없습니다.");
        }
    }
}
