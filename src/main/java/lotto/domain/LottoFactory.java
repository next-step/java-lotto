package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoFactory {
    private List<Integer> numbers = new ArrayList<>();
    private int MAX_COUNT = 6;

    public LottoFactory(Random random) {
        while (numbers.size() < MAX_COUNT) {
            int randomNumber = random.nextInt(45) + 1;
            addNumber(randomNumber);
        }
        Collections.sort(numbers);
    }

    private void addNumber(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    public List<Integer> numbers() {
        return this.numbers;
    }
}
