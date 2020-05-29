package lotto.domain.number;

import lotto.domain.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(NumberGenerator generator) {
        this.numbers = createLottoNumbers(generator);
    }

    private List<LottoNumber> createLottoNumbers(NumberGenerator generator) {
        List<Integer> integers = generator.getNumbers();

        return integers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
