package lotto.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.lang.String.format;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ILLEGAL_ARGUMENT_FORMAT = "한 게임에 로또 번호는 %d개 입니다.";
    private static final String ILLEGAL_ARGUMENT_MESSAGE
            = format(ILLEGAL_ARGUMENT_FORMAT, LOTTO_NUMBER_COUNT);

    Set<LottoNumber> values;

    public LottoNumbers(Set<LottoNumber> values) {
        validate(values);
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    private void validate(Set<LottoNumber> values) {
        if (values.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }

    private void allocateValues(Set<Integer> initializingValues) {
        values = new HashSet<>();

        for(int initializingValue : initializingValues) {
            values.add(LottoNumber.from(initializingValue));
        }
    }
}
