package lotto.domain;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    private int matchCount;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    void incrMatchCount(int number) {
        if (numbers.contains(number)) {
            matchCount++;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        String value = "[";
        for (int number : numbers) {
            value += number;
            value += ", ";
        }
        value = value.substring(0,value.length()-2) + "]";

        return value;
    }
}
