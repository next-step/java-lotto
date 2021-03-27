package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class FixedGenerator implements LottoNumberGenerator {
    private final List<Integer> referenceNumbers;

    public FixedGenerator(List<Integer> referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    @Override
    public List<Integer> extractLottoNumber() {
        return referenceNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
