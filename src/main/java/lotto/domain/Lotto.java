package lotto.domain;

import java.util.Arrays;

public class Lotto {

    private final Integer[] numbers;
    private int matchingCount = 0;

    public Lotto(Integer[] numbers) {
        this.numbers = numbers;
    }

    public Lotto(Integer[] numbers, int matchingCount) {
        this.numbers = numbers;
        this.matchingCount = matchingCount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    private void draw(Lotto luckyLotto, Integer value) {
        if (luckyLotto.contains(value)) {
            addWinningNumberCount();
        }
    }

    private boolean contains(Integer value) {
        return Arrays.asList(numbers).contains(value);
    }

    private void addWinningNumberCount() {
        this.matchingCount++;
    }

    public Lotto drawAutomaticLotto(Lotto luckyLotto) {
        for (Integer number : numbers) {
            draw(luckyLotto, number);
        }
        return this;
    }

    public void print() {
        System.out.println(Arrays.toString(numbers));
    }
}
