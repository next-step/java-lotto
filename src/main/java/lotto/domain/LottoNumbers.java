package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int TOTAL_NUMBER_OF_THE_LOTTO = 6;

    private final Set<LottoNumber> values;

    private LottoNumbers(final Set<LottoNumber> values) {
        validate(values);
        this.values = new TreeSet<>(values);
    }

    public LottoNumbers(final int... values) {
        this(
                Arrays.stream(values)
                        .mapToObj(LottoNumber::from)
                        .collect(Collectors.toSet())
        );
    }

    public List<LottoNumber> get() {
        return new ArrayList<>(this.values);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.values
                .contains(lottoNumber)
                ;
    }

    public long howManyMatches(final LottoNumbers winningNumber) {
        return this.values
                .stream()
                .filter(value -> winningNumber.values.contains(value))
                .count()
                ;
    }

    private void validate(final Set<LottoNumber> values) {
        if (values.size() != TOTAL_NUMBER_OF_THE_LOTTO) {
            throw new IllegalArgumentException();
        }
    }
}
