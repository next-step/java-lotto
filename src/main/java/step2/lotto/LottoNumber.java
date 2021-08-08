package step2.lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Stream<Integer> stream() {
        return this.numbers.stream();
    }

    public long countOfMatches(LottoNumber lottoNumber) {
        return lottoNumber.stream()
                .filter(this.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
