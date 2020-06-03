package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> lottoNumberList) {
        Set<Integer> lottoNumberSet = lottoNumberList.stream().filter(i -> MIN_NUMBER <= i && i <= MAX_NUMBER).collect(Collectors.toSet());
        if (lottoNumberSet.size() != 6) {
            throw new IllegalArgumentException("`lottoNumber` is invalid");
        }
        this.lottoNumbers = new LottoNumbers(lottoNumberSet);
    }

    public List<Integer> getLottoNumberList() {
        return new ArrayList<>(lottoNumbers.getLottoNumberSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
