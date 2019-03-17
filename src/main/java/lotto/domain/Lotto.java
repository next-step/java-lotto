package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<Integer> numbers;

    private int matchCount;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.matchCount = 0;
    }

    public Lotto(List<Integer> numbers, int matchCount) {
        this.numbers = numbers;
        this.matchCount = matchCount;
    }

    /**
     * 맞은 숫자 개수 증가
     * @param number 당첨번호 한개
     */
    void incrementMatchCount(int number) {
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
