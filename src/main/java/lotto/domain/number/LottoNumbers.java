package lotto.domain.number;

import lotto.domain.generator.NumberGenerator;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
