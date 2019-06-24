package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    List<Integer> lotto;

    public Lotto() {
    }

    public Lotto(List<Integer> lotto) {
        this.valideLottoNumber(lotto);
        this.lotto = lotto;
    }

    public boolean valideLottoNumber(List<Integer> lotto){
        int cnt = (int) lotto.stream().distinct().filter(x -> x > 0 && x <=45).count();
        if (cnt != 6){
            throw new IllegalArgumentException();
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
