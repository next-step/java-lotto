package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int MAX_LENGTH_LOTTO = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this(IntStream.range(0, MAX_LENGTH_LOTTO)
                .mapToObj((int i) -> new LottoNumber())
                .collect(Collectors.toList()));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
