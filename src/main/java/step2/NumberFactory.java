package step2;

import java.util.ArrayList;
import java.util.List;

public class NumberFactory {

    private final int LOTTO_PRICE = 1000;

    private final NumberGenerateStrategy strategy;
    private final List<List<Integer>> numbers = new ArrayList<>();

    public NumberFactory(NumberGenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public List<List<Integer>> createNumber(int price) {
        int amount = price / LOTTO_PRICE;

        for (int i = 0; i < amount; i++) {
            List<Integer> generate = strategy.generate();
            numbers.add(new ArrayList<>(generate));
        }

        return numbers;
    }
}
