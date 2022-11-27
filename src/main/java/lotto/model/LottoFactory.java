package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private final List<String> numbers;

    public LottoFactory(List<String> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public Lotto stringToLotto() {
        return new Lotto(numbers.stream()
                .map(number -> LottoNumber.lottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toSet()));
    }
}
