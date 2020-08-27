package cc.oakk.lotto.model;

import cc.oakk.lotto.view.printer.Printable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class Lotto implements Printable<String> {
    public static final int NUMBER_COUNT = 6;
    public static final LottoNumberRange RANGE = LottoNumberRange.between(1, 45);

    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        throwIfNull(numbers);
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("Lotto's number size must be %d!", NUMBER_COUNT));
        }

        List<Integer> validatedList = numbers.stream()
                .map(Lotto::throwIfNotValidNumber)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        if (validatedList.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto's number should not be duplicated.");
        }
        this.numbers = Collections.unmodifiableList(validatedList);
    }

    public Rank score(WinningLotto target) {
        throwIfNull(target);
        int matchingCount = (int) numbers.stream()
                .filter(target.numbers::contains)
                .count();
        return Rank.getRankByDifferentCount(NUMBER_COUNT - matchingCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private static int throwIfNotValidNumber(int target) {
        if (!RANGE.isValidNumber(target)) {
            throw new IllegalArgumentException(String.format("%d is out of range.", target));
        }
        return target;
    }

    @Override
    public String print() {
        return toString();
    }
}
