package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;

    private List<Integer> numbers;

    public LottoGenerator() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public LottoGenerator(int count) {
        numbers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(numbers);
        List<Integer> shuffledNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            shuffledNumbers.add(numbers.get(i));
        }
        return sort(shuffledNumbers);
    }

    private List<Integer> sort(List<Integer> shuffledNumbers) {
        Collections.sort(shuffledNumbers);
        return shuffledNumbers;
    }
}
