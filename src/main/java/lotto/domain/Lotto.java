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

    private int countMatchedNumbers(List<Integer> winningNumbers) {
        return (int) this.numbers.getNumbers()
                .stream()
                .map(Number::getNumber)
                .filter(winningNumbers::contains)
                .count();
    }

    List<Integer> getNumbers() {
        return this.numbers.getNumbers()
                .stream()
                .map(Number::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String convertedNumbers = numbers.getNumbers()
                .stream()
                .map(Number::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + convertedNumbers + "]";
    }
}
