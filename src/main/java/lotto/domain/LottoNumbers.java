package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> value;

    public LottoNumbers(List<LottoNumber> value) {
        this.value = value;
    }

    public List<LottoNumber> getValue() {
        return value;
    }

    public List<Integer> getIntegerValues() {
        return value.stream().map(LottoNumber::getValue).collect(Collectors.toList());
    }
}
