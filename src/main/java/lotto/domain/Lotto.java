package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1_000;

    private final Numbers numbers;

    public Lotto() {
        numbers = new Numbers();
    }

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    LottoResultType findLottoResultType(List<Integer> winningNumbers) {
        return LottoResultType.findByMatchedCount(countMatchedNumbers(winningNumbers));
    }

    List<Integer> getNumbers() {
        return this.numbers.getNumbers()
                .stream()
                .map(Number::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("[%s]", numbers());
    }

    private String numbers() {
        return numbers.getNumbers()
                .stream()
                .map(Number::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private int countMatchedNumbers(List<Integer> winningNumbers) {
        return this.numbers.matchedCount(winningNumbers);
    }
}
