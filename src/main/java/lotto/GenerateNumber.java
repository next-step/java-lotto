package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateNumber {
    private final static int BOUND = 45;
    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= BOUND; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<Integer> randoms = numbers.subList(0, 6);
        Collections.sort(randoms);

        return randoms;
    }

    public List<Integer> generateNumbers(List<Integer> numbers) {
        return numbers.subList(0,6);
    }
}
