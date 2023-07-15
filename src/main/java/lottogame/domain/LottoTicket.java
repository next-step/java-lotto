package lottogame.domain;

import lottogame.domain.spi.NumberGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class LottoTicket {

    public static final int PURCHASABLE_UNIT = 1000;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> values;

    public LottoTicket(NumberGenerator numberGenerator) {
        Objects.requireNonNull(numberGenerator, "numberGeneartor는 Null이 되면 안됩니다.");
        this.values = initValues(numberGenerator.generateDistinctNumbers(LOTTO_NUMBERS_SIZE));
    }

    protected LottoTicket(Set<Integer> values) {
        this.values = initValues(values);
    }

    private Set<LottoNumber> initValues(Set<Integer> values) {
        assertValues(values);
        return values.stream()
            .map(LottoNumber::valueOf)
            .collect(Collectors.toSet());
    }

    private void assertValues(Set<Integer> values) {
        Objects.requireNonNull(values, "values는 Null이 되면 안됩니다.");

        if (values.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                String.format("values의 size는 %d 이여야 합니다. values.size() \"%d\"", LOTTO_NUMBERS_SIZE,
                    values.size()));
        }
    }

    int getMatchedCount(LottoTicket lottoTicket) {
        return (int) values.stream()
            .filter(lottoTicket::contains)
            .count();
    }

    boolean contains(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    public Set<Integer> getValues() {
        return values.stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicket)) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
            "values=" + values +
            '}';
    }
}
