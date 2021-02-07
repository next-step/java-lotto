package lotto.domain;

import java.util.List;

public class WinnerLotto {
    // extends keyword 제거됨
    private final LottoNumber bonusBall;
    private final Lotto winnersLotto;
    public WinnerLotto(LottoNumber bonusBall, Lotto winnersLotto) {

        checkLottoContainsBonusball(bonusBall, winnersLotto.getNumbers());
        this.winnersLotto = winnersLotto;
        this.bonusBall = bonusBall;
    }

    public Lotto getWinnersLotto() {
        return winnersLotto;
    }

    public List<LottoNumber> getNumbers() {
        return winnersLotto.getNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private void checkLottoContainsBonusball (LottoNumber bonusBall, List<LottoNumber> numbers) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스번호가 로또번호와 중복됩니다.");
        }
    }

    public static WinnerLotto of (LottoNumber bonusBall, List<LottoNumber> numbers) {
        return new WinnerLotto(bonusBall, Lotto.of(numbers));
    }


    public Prize getPrizeForEachLotto(Lotto lotto) {
        int matchedCount = winnersLotto.getMatchedCount(lotto);
        boolean isBonus = lotto.contains(bonusBall);
        return Prize.getPrizeByMatchedNumber(matchedCount,isBonus);
    }


}
