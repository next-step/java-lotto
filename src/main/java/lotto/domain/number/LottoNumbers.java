package lotto.domain.number;

import lotto.domain.generator.NumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    public final static int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    // TODO 정적 팩토리 메소드
    public LottoNumbers(NumberGenerator generator) {
        this.numbers = createLottoNumbers(generator);
    }

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = createLottoNumbersThroughInteger(numbers);
    }

    private List<LottoNumber> createLottoNumbersThroughInteger(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
