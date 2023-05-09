package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoMatcher match(List<LottoNumber> targetNumbers, LottoNumber bonusNumber) {
        int matchedSize = lottoNumbers.stream()
                .filter(targetNumbers::contains)
                .collect(Collectors.toList())
                .size();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);
        return LottoMatcher.of(matchedSize, matchBonus);
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
