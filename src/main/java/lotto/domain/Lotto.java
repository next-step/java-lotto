package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberSizeException;
import lotto.domain.exception.NotNumberStringException;
import lotto.domain.exception.OutOfRangeLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int SUM_OF_TWO_ELEMENTS_MAX_SIZE = 12;

    public static final int MAX_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final Set<Integer> elements;

    public Lotto(final Set<Integer> elements) {
        NullCheckUtil.validate(elements);
        validate(elements);
        this.elements = elements;
    }

    public Lotto(final List<Integer> elements) {
        this(new HashSet<>(elements));
    }

    public static Lotto from(final List<String> elements) {
        List<Integer> intElements = elements.stream()
                .map(Lotto::parseInt)
                .collect(Collectors.toList());
        return new Lotto(intElements);
    }

    private void validate(final Set<Integer> elements) {
        validateElementsRange(elements);
        validateElementsSize(elements);
    }

    private void validateElementsRange(final Set<Integer> elements) {
        elements.forEach(this::existsWithinLottoNumberRange);
    }

    private void existsWithinLottoNumberRange(final int element) {
        if (element < MIN_NUMBER || element > MAX_NUMBER) {
            throw OutOfRangeLottoNumberException.getInstance();
        }
    }

    private void validateElementsSize(final Set<Integer> elements) {
        if (elements.size() != MAX_SIZE) {
            throw InvalidLottoNumberSizeException.getInstance();
        }
    }

    private static int parseInt(String stringValue) {
        try {
            return Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.getInstance();
        }
    }

    public int countMatches(Lotto lastWeekLotto) {
        Set<Integer> combinedElements = new HashSet<>(this.elements);
        combinedElements.addAll(lastWeekLotto.elements);
        return SUM_OF_TWO_ELEMENTS_MAX_SIZE - combinedElements.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return elements.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
