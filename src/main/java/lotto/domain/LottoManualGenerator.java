package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManualGenerator implements GenerateStrategy {
    private final List<LottoNumber> parsedNumber;

    public LottoManualGenerator(final List<LottoNumber> parsedNumber) {
        this.parsedNumber = new ArrayList<>(parsedNumber);
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        return parsedNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoManualGenerator)) return false;
        LottoManualGenerator that = (LottoManualGenerator) o;
        return Objects.equals(parsedNumber, that.parsedNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parsedNumber);
    }
}
