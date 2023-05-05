package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoMatcher match(List<LottoNumber> targetNumbers) {
        int matchedSize = lottoNumbers.stream()
                .filter(targetNumbers::contains)
                .collect(Collectors.toList())
                .size();
        return LottoMatcher.of(matchedSize);
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
