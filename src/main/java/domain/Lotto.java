package domain;

import strategy.LottoNumberGenerator;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {
    private List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto of(LottoNumberGenerator randomLottoNumberGenerator) {
        return randomLottoNumberGenerator
                .generator()
                .stream()
                .sorted()
                .collect(collectingAndThen(toList(), Lotto::of));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public long hasWinningNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }
}
