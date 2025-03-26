package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateNumber {
    private final static int BOUND = 45;
    private final List<Integer> numbers;

    public GenerateNumber() {
        numbers = new ArrayList<>();

        for (int i = 1; i < BOUND; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> generateRandomNumbers() {
        Collections.shuffle(numbers);
        Collections.sort(numbers);
        return numbers.subList(0,6);
    }

    public List<Integer> generateNumbers(List<Integer> numbers) {
        return numbers.subList(0,6);
    }
}
