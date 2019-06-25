package lotto.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoRandomStrategy implements LottoNumberStrategy {
    @Override
    public List<Integer> generate() {
        List<Integer> numbers = getOrderedNumbers();

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    private List<Integer> getOrderedNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            numbers.add(i);
        }

        return numbers;
    }
}
