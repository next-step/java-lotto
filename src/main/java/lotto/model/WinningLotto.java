package lotto.model;

import lotto.exception.DuplicateLottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final Number number;

    public WinningLotto(Lotto lotto, Number number) {
        this.lotto = lotto;
        this.number = number;
    }

    public static WinningLotto generate(String inputOfNumber, int inputOfBonus) {
        List<Number> numbers = Arrays.stream(inputOfNumber.trim().split(","))
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(Collectors.toList());

        Lotto lotto = Lotto.from(numbers);
        Number number = Number.of(inputOfBonus);
        if(lotto.hasBonusNumber(number)){
            throw new DuplicateLottoNumberException(inputOfBonus);
        }
        return new WinningLotto(lotto, number);
    }

    Lotto getLotto() {
        return lotto;
    }

    Number getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, number);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto +
                ", number=" + number +
                '}';
    }
}
