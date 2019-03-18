package lotto;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchNumbers(List<Integer> luckyNumbers) {
        int matchCount = 0;

        for (int luckyNumber : luckyNumbers) {
            matchCount = checkLuckyNumber(luckyNumber, matchCount);
        }
        return matchCount;
    }

    private int checkLuckyNumber(int luckyNumber, int matchCount) {
        if (numbers.contains(luckyNumber)) {
            matchCount++;
        }
        return matchCount;
    }


    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
