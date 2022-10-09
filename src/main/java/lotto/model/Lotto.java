package lotto.model;

import lotto.exception.InvalidLottoSizeException;

import java.util.List;
import java.util.Objects;

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

    public int getMatchCount(List<LottoNumber> lastWinLotto) {
        return toIntExact(lastWinLotto.stream()
                .filter(lotto::contains)
                .count());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(this.lotto, lotto.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
