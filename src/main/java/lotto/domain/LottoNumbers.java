package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final Set<Integer> elements;

    public LottoNumbers(final Set<Integer> elements) {
        validate(elements);
        this.elements = elements;
    }

    public LottoNumbers(final List<Integer> elements) {
        this(new HashSet<>(elements));
    }

    private void validate(final Set<Integer> elements) {
        validateElementsRange(elements);
        validateElementsSize(elements);
    }

    private void validateElementsRange(final Set<Integer> elements) {
        elements.forEach(this::existsLottoNumberRange);
    }

    private void existsLottoNumberRange(final int element) {
        if (element < 1 || element > 45) {
            throw OutOfRangeLottoNumberException.of();
        }
    }

    private void validateElementsSize(final Set<Integer> elements) {
        if (elements.size() != 6) {
            throw InvalidLottoNumbersSizeException.of();
        }
    }

    public List<Integer> findNumbersSortedAsc() {
        return elements.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
