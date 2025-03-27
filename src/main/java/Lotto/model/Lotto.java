package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.List;

public class Lotto {
    private final NumberExtractor extractor;
    private List<Integer> numbers;

    public Lotto(NumberExtractor extractor) {
        this.extractor = extractor;
    }

    public void draw(int size, int min, int max) {
        numbers = this.extractor.extract(size, min, max);
    }

    public int checkMatched(int[] winNumbers) {
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
