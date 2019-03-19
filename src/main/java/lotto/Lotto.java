package lotto;

import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (isWrongSize(numbers.size())) {
            throw new RuntimeException();
        }
        this.numbers = numbers;
    }

    private boolean isWrongSize(int size) {
        if (size != NUMBER_COUNT) {
            return true;
        }
        return false;
    }

    public int matchNumbers(Lotto luckyNumbers) {
        int matchCount = 0;
        for (int luckyNumber : luckyNumbers.numbers) {
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
