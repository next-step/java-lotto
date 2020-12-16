package step2.domain;

import java.util.Collections;
import java.util.List;

public final class LottoNumbers<T> {
    private final List<T> lottoNumbers;

    public LottoNumbers(List<T> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<T> getLottoNumbers() {
        return lottoNumbers;
    }

    public long getEqualNumberCount(List<T> targetNumbers) {
        return lottoNumbers.stream()
                .filter(targetNumbers::contains)
                .count();
    }
}