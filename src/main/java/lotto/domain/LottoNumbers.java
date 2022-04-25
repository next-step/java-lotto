package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = IntStream.range(0, 6)
                .mapToObj(it -> new LottoNumber())
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
