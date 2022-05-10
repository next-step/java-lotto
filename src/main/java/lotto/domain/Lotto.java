package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber())).
                collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }
}
