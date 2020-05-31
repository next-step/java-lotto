package lotto.domain.number;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.winning.WinningNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    public final static int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers newLottoNumbersWithNumberGenerator(NumberGenerator<LottoNumber> generator) {
        return new LottoNumbers(createLottoNumbers(generator));
    }

    public static LottoNumbers newLottoNumbersWithList(List<Integer> numbers) {
        return new LottoNumbers(createLottoNumbersThroughInteger(numbers));
    }

    private static List<LottoNumber> createLottoNumbersThroughInteger(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> createLottoNumbers(NumberGenerator<LottoNumber> generator) {
        return generator.getNumbers();
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
