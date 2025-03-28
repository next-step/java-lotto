package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private final List<Integer> numbers;

    public LottoNumberGenerator() {
        this.numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(numbers);
        List<Integer> generatedNumbers = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(generatedNumbers);
        return generatedNumbers;
    }
}
