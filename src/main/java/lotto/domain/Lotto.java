package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto createLotto() {
        List<Integer> lottoAllNum = Stream.iterate(1, n -> n + 1).limit(45).collect(Collectors.toList());
        Collections.shuffle(lottoAllNum);
        return new Lotto(
                lottoAllNum.subList(0, 6));
    }

    public List<Integer> getLotto() {
        return lotto;
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
