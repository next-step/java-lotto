package lotto.model;

import lotto.exception.InvalidLottoSizeException;

import java.util.List;

import static java.lang.Math.toIntExact;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;

        if (lotto.size() != 6) {
            throw new InvalidLottoSizeException(String.format("[사이즈 오류] 로또는 6개의 숫자가 생성되어야 합니다. %s", lotto.size()));
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public double matchCount(List<LottoNumber> lastWinLotto) {
        return toIntExact(lastWinLotto.stream()
                .filter(lotto::contains)
                .count());
    }

    public double matchBonusBallCount(int bonusBall) {
        return lotto.contains(new LottoNumber(bonusBall)) ? 0.5 : 0;
    }
}
