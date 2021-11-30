package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<String> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
                                     .map(LottoNumber::new)
                                     .collect(Collectors.toList()));
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                                 .filter(lotto.lottoNumbers::contains)
                                 .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
