package lotto.model;

import lotto.exception.DuplicateLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningLottoRequest {

    private final List<Number> numbers;
    private final Number bonus;

    public WinningLottoRequest(List<Number> numbers, Number bonus) {
        this.numbers = new ArrayList<>(numbers);
        this.bonus = bonus;
    }

    public static WinningLottoRequest of(String numbers, int bonus) {
        List<Integer> numberList = Arrays.stream(numbers.trim().split(","))
                .distinct()
                .map(Integer::new)
                .collect(Collectors.toList());

        if(numberList.contains(bonus)){
            throw new DuplicateLottoNumberException(numbers, bonus);
        }
        return new WinningLottoRequest(numberList.stream().map(Number::of).collect(Collectors.toList()), Number.of(bonus));
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
