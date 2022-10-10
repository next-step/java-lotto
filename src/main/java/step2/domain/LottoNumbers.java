package step2.domain;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> LottoNumbers) {
        this.lottoNumbers = LottoNumbers;
    }

    public int compareMatch(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getLottoNumbers().stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
