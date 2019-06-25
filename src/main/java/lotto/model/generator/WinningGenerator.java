package lotto.model.generator;

import lotto.exception.DuplicateLottoNumberException;
import lotto.model.Lotto;
import lotto.model.Number;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningGenerator implements LottoGenerator {

    private List<Number> numbers;
    private int bonus;

    private WinningGenerator(List<Number> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public static WinningGenerator generate(String numbers, int bonus) {
        List<Number> numberList = Arrays.stream(numbers.trim().split(","))
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(toList());
        duplicateBonusNumber(numberList, bonus);
        return new WinningGenerator(numberList, bonus);
    }

    private static void duplicateBonusNumber(List<Number> numbers, int bonus) {
        if (numbers.contains(Number.of(bonus))) {
            throw new DuplicateLottoNumberException(bonus);
        }
    }

    @Override
    public Lotto generator() {
        return Lotto.from(numbers);
    }

    public Number getBonus() {
        return Number.of(bonus);
    }
}
