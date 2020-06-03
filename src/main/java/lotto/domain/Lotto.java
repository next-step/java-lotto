package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final Set<Integer> lottoNumberSet;

    public Lotto(List<Integer> lottoNumberSet) {
        this.lottoNumberSet = lottoNumberSet.stream().filter(i -> MIN_NUMBER <= i && i <= MAX_NUMBER).collect(Collectors.toSet());
        if (this.lottoNumberSet.size() != 6) {
            throw new IllegalArgumentException("`lottoNumber` is invalid");
        }
    }

    public List<Integer> getLottoNumberSet() {
        return new ArrayList<>(lottoNumberSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberSet, lotto.lottoNumberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberSet);
    }
}
