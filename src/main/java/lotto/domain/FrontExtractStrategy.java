package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class FrontExtractStrategy implements ExtractStrategy {
    private static final int MAX_LOTTO_NUMBER = 45;
    @Override
    public List<Integer> extractNumber(int number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers.subList(0, number);
    }
}
