package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int SIZE = 6;
    private final NumberExtractor extractor;
    private List<Integer> numbers;

    public Lotto(NumberExtractor extractor) {
        this.extractor = extractor;
    }

    public void draw() {
        numbers = this.extractor.extract(SIZE);
        Collections.sort(numbers);
    }

    public int checkMatched(List<Integer> winNumbers) {
        int matchedNum = 0;
        for (int num : winNumbers) {
            if (this.numbers.contains(num)) {
                matchedNum++;
            }
        }

        return matchedNum;
    }


    List<Integer> numbers() {
        return numbers;
    }
}
