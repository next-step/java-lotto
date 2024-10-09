package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int PER_COST = 1000;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        this(new ArrayList<>(LOTTO_SIZE));
    }

    public Lotto(List<Integer> lottoNumbers) {
        lotto.addAll(lottoNumbers);
    }

    public int calculateCount(int money) {
        return money / PER_COST;
    }

    public List<Integer> getLottoNumbers() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Lotto))
            return false;
        Lotto lotto1 = (Lotto)o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lotto);
    }
}
