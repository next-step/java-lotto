package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLottoRequest {

    private final List<Number> numbers;
    private final Number bonus;

    public WinningLottoRequest(String numbers, int bonus) {
        this.numbers = Arrays.stream(numbers.trim().split(","))
                .map(Integer::new)
                .map(Number::of)
                .collect(Collectors.toList());
        this.bonus = Number.of(bonus);
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
