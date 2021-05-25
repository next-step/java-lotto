package lotto.domain;

import java.util.Objects;
import java.util.Set;

import static java.lang.String.format;

public class LottoGame {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final String ILLEGAL_ARGUMENT_FORMAT = "한 게임에 로또 번호는 %d개 입니다.";
    private static final String ILLEGAL_ARGUMENT_MESSAGE
            = format(ILLEGAL_ARGUMENT_FORMAT, LOTTO_NUMBER_COUNT);

    private Set<LottoNumber> values;

    public LottoGame(Set<LottoNumber> values) {
        validate(values);
        this.values = values;
    }

    public int size() {
        return values.size();
    }

    public boolean find(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame that = (LottoGame) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    private void validate(Set<LottoNumber> values) {
        if (values.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }
}
