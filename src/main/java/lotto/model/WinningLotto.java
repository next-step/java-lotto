package lotto.model;

import lotto.exception.InvalidLottoSizeException;
import lotto.model.enumeration.Rank;

import java.util.List;

import static java.lang.Math.toIntExact;

public class WinningLotto {

    private List<LottoNumber> lastWinningLotto;
    private LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> lastWinningLotto, LottoNumber bonusBall) {
        this.lastWinningLotto = lastWinningLotto;
        this.bonusBall = bonusBall;

        if (lastWinningLotto.size() != 6) {
            throw new InvalidLottoSizeException(String.format("[사이즈 오류] 로또는 6개의 숫자가 생성되어야 합니다. %s", lastWinningLotto.size()));
        }
    }

    public Rank match(Lotto lotto) {
        double matchLottoCount = toIntExact(lotto.getLotto().stream()
                .filter(lastWinningLotto::contains)
                .count());

        boolean isMatchBonusBall = lotto.getLotto().contains(bonusBall);

        return Rank.valueOf(matchLottoCount, isMatchBonusBall);
    }
}
