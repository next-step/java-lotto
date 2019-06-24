package lotto.model;

import lotto.exception.DuplicateLottoNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class WinningLottoRequest {

    private final List<Number> numbers;
    private final Number bonus;

    public WinningLottoRequest(List<Number> numbers, Number bonus) {
        this.numbers = new ArrayList<>(numbers);
        this.bonus = bonus;
    }

    public static WinningLottoRequest of(String inputOfNumbers, int bonus) {
        duplicatedLottoNumber(parseNumbers(inputOfNumbers), bonus);

        List<Number> numbers = parseNumbers(inputOfNumbers).stream()
                .map(Number::of)
                .collect(toList());
        return new WinningLottoRequest(numbers, Number.of(bonus));
    }

    private static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.trim().split(","))
                .distinct()
                .map(Integer::new)
                .collect(toList());
    }

    private static void duplicatedLottoNumber(List<Integer> numberList, int bonus) {
        if ((numberList.size() < Lotto.SIZE) || (numberList.contains(bonus))) {
            throw new DuplicateLottoNumberException(numberList, bonus);
        }
    }

    List<Number> getNumbers() {
        return numbers;
    }

    Number getBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoRequest that = (WinningLottoRequest) o;
        return Objects.equals(numbers, that.numbers) &&
                Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, bonus);
    }

    @Override
    public String toString() {
        return "WinningLottoRequest{" +
                "numbers=" + numbers +
                ", bonus=" + bonus +
                '}';
    }
}
