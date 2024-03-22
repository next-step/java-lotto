package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers of(List<Integer> lottoNumbers) {
        return new LottoNumbers(lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
