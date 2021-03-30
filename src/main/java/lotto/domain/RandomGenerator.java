package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator implements LottoNumberGenerator {
    private final static int MIN = 0;
    private final static int MAX = 6;
    private final List<Integer> referenceNumbers;

    public RandomGenerator() {
        referenceNumbers = createReferenceNumbers();
    }

    @Override
    public List<Integer> extractLottoNumber() {
        Collections.shuffle(referenceNumbers);

        return referenceNumbers.subList(RandomGenerator.MIN, RandomGenerator.MAX)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> createReferenceNumbers() {
        List<Integer> referenceNumbers = new ArrayList<>();
        for (int i = Lotto.LOTTO_FIRST_NUMBER; i <= Lotto.LOTTO_LAST_NUMBER; i++) {
            referenceNumbers.add(i);
        }
        return referenceNumbers;
    }
}
