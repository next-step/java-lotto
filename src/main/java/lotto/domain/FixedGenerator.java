package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class FixedGenerator implements LottoNumberGenerator {
    private final static int MIN = 0;
    private final static int MAX = 6;
    private final List<Integer> referenceNumbers;

    public FixedGenerator(List<Integer> referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    @Override
    public List<Integer> extractLottoNumber() {
        return referenceNumbers.subList(FixedGenerator.MIN, FixedGenerator.MAX)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
