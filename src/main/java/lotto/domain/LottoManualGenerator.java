package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManualGenerator implements GenerateStrategy {
    private final List<Integer> parsedNumber;

    public LottoManualGenerator(final List<Integer> parsedNumber) {
        this.parsedNumber = new ArrayList<>(parsedNumber);
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        return convertToLottoNumbers(parsedNumber);
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
