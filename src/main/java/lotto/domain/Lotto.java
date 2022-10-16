package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberSizeException;
import lotto.util.NullCheckUtil;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MAX_SIZE = 6;

    private final Set<LottoNumber> elements;

    public Lotto(final Set<LottoNumber> elements) {
        validate(elements);
        this.elements = elements;
    }

    public static Lotto from(final List<String> values) {
        Set<LottoNumber> lottoNumbers = values.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }

    private void validate(final Set<LottoNumber> elements) {
        NullCheckUtil.validate(elements);
        validateElementsSize(elements);
    }

    private void validateElementsSize(final Set<LottoNumber> elements) {
        if (elements.size() != MAX_SIZE) {
            throw InvalidLottoNumberSizeException.getInstance();
        }
    }

    public int countMatches(Lotto lastWeekLotto) {
        return lastWeekLotto.elements
                .stream()
                .filter(this::isMatch)
                .collect(Collectors.toSet())
                .size();
    }

    public boolean isMatch(LottoNumber lottoNumber) {
        return elements.contains(lottoNumber);
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
        return elements.toString();
    }
}
