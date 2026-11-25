package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_SIZE = 6;

    public List<Integer> generate() {
        List<Integer> candidates = createCandidates();
        Collections.shuffle(candidates);
        List<Integer> numbers = new ArrayList<>(candidates.subList(0, NUMBERS_SIZE));
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer> createCandidates() {
        List<Integer> candidates = new ArrayList<>();
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            candidates.add(number);
        }
        return candidates;
    }
}
