package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generate() {
        List<Integer> candidates = createCandidates();
        Collections.shuffle(candidates);
        List<Integer> numbers = new ArrayList<>(candidates.subList(0, Lotto.NUMBERS_SIZE));
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer> createCandidates() {
        List<Integer> candidates = new ArrayList<>();
        for (int number = Lotto.MIN_NUMBER; number <= Lotto.MAX_NUMBER; number++) {
            candidates.add(number);
        }
        return candidates;
    }
}
