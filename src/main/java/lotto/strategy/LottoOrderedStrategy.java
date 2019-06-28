package lotto.strategy;

import java.util.ArrayList;
import java.util.List;

public class LottoOrderedStrategy implements LottoNumberStrategy {
    @Override
    public List<Integer> generate() {
        return getOrderedNumbers().subList(0, 6);
    }

    private List<Integer> getOrderedNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            numbers.add(i);
        }

        return numbers;
    }
}
