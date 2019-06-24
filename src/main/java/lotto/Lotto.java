package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> lotto;
    private final int LOTTO_BASE_BOUND = 6;

    public Lotto() {
    }

    public Lotto(List<Integer> lotto) {
        this.valideLottoNumber(lotto);
        this.lotto = lotto;
    }

    public boolean valideLottoNumber(List<Integer> lotto) {
        int cnt = (int) lotto.stream().distinct().filter(x -> x > 0 && x <= 45).count();
        if (cnt != LOTTO_BASE_BOUND) {
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

    public int howManySameLottoNumber(List<Integer> result) {
        List<Integer> temp = new ArrayList<>(result);
        temp.addAll(this.lotto);
        long count = temp.stream().distinct().count();
        if (count == LOTTO_BASE_BOUND) {
            return LOTTO_BASE_BOUND;
        }
        return (int) count - LOTTO_BASE_BOUND;
    }
}
