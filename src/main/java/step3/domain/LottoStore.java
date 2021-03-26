package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 45;
    private final List<Integer> baseNumbers;

    public LottoStore() {
        baseNumbers = createBaseNumbers();
    }

    public List<Integer> createBaseNumbers() {
        return IntStream.rangeClosed(MIN_NUM, MAX_NUM)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }

    private void shuffleBaseNumbers(List<Integer> basicNumbers) {
        Collections.shuffle(basicNumbers);
    }

    public List<Integer> createIntegers() {
        shuffleBaseNumbers(baseNumbers);
        return baseNumbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }
}