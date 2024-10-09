package step3.model;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    //로또번호가 이미 존재하지는 확인한다.
    public boolean confirmExistLottoNum(int num) {
        return this.lotto.stream().anyMatch(l -> l.confirmLottoNum(num));
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(this.lotto, lotto.getLotto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lotto);
    }
}
