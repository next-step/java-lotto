package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoGenerator(int from, int to) {
        for (int i = from; i <= to; i++) {
            this.lottoNumbers.add(i);
        }
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(numbers);
        return numbers.subList(START_INDEX,END_INDEX);
    }
}
