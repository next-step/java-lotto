package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public static final int TOTAL_NUMBER_OF_THE_LOTTO = 6;

    private final List<LottoNumber> values;

    public LottoNumbers(final List<LottoNumber> values) {
        validate(values);
        Collections.sort(values);
        this.values = new ArrayList<>(values);
    }

    public List<LottoNumber> get() {
        return new ArrayList<>(this.values);
    }

    long howManyMatches(final LottoNumbers winningNumber) {
        return this.values
                .stream()
                .filter(value -> winningNumber.values.contains(value))
                .count()
                ;
    }

    private void validate(final List<LottoNumber> values) {
        checkTotalNumber(values);
        checkDuplicateNumbers(values);
    }

    private void checkTotalNumber(final List<LottoNumber> values) {
        if (values.size() != TOTAL_NUMBER_OF_THE_LOTTO) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumbers(final List<LottoNumber> values) {
        final long count = values.stream()
                .distinct()
                .count()
                ;
        if (count < values.size()) {
            throw new IllegalArgumentException();
        }
    }
}
