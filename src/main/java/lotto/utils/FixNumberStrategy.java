package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class FixNumberStrategy implements NumberStrategy {

    private final List<LottoNumber> lottoNumbers;

    public FixNumberStrategy(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

}
