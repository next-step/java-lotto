package lotto.model;

import java.util.*;

import static lotto.model.LottosFactory.LOTTO_MAX_LENGTH;
import static lotto.model.Rank.*;

public class Lotto {
    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validation(lotto);
        this.lotto = lotto;
    }

    private void validation(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_MAX_LENGTH) {
            throw new IllegalArgumentException("로또의 개수를 확인해주세요");
        }
    }

    public Rank rank(WinningLotto winningLotto) {
        return findRank(counting(winningLotto), isBonus(winningLotto, lotto));
    }

    private int counting(WinningLotto winningLotto) {
        return (int) lotto.stream()
                .filter(winningLotto::isMatch)
                .count();
    }

    private boolean isBonus(WinningLotto winningLotto, Set<LottoNumber> lotto) {
        return lotto.stream()
                .anyMatch(winningLotto::isMatchBonus);
    }

    public boolean isMatch(LottoNumber buyLottoNumber) {
        return lotto.stream()
                .anyMatch(winningNum -> winningNum.isMatchNumber(buyLottoNumber));
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return lotto.equals(lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
