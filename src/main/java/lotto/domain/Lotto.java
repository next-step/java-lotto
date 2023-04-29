package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(final List<Integer> list) {
        this.lottoNumbers = new LottoNumbers(new HashSet<>(list));
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }
}
