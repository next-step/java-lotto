package lotto.domain.number;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.winning.WinningNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    public final static int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public static LottoNumbers newLottoNumbersWithNumberGenerator(NumberGenerator generator) {
        return new LottoNumbers(generator);
    }

    public static LottoNumbers newLottoNumbersWithList(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    private LottoNumbers(NumberGenerator generator) {
        this.numbers = createLottoNumbers(generator);
    }

    private LottoNumbers(List<Integer> numbers) {
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

    public int matchCount(WinningNumbers winningNumbers) {
        return Math.toIntExact(
                this.numbers.stream()
                        .filter(winningNumbers::contains)
                        .count()
        );
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
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
