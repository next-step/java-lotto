package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers = new ArrayList<>();

    public AutoLottoNumberGenerator() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    @Override
    public List<Integer> generate() {
        List<Integer> generatedNumbers = new ArrayList<>(shuffleAndExtractNumbers());
        Collections.sort(generatedNumbers);

        return generatedNumbers;
    }

    private List<Integer> shuffleAndExtractNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(FROM_INDEX, TO_INDEX);
    }
}
