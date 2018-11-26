package lotto;

import java.util.Set;

public class Lotto {
    private static final int MINIMUM_VALUE = 3;
    private Set<Integer> numbers;
    private int numberofCount;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public void countbyComparingNumbers(Set<Integer> winningNumber) {
        for (int number : winningNumber) {
            this.numberofCount = counting(this.numberofCount, number);
        }
    }

    private int counting(int count, int number) {
        if (this.numbers.contains(number))
            return ++this.numberofCount;
        return this.numberofCount;
    }

    public LottoType findLottoType() {
        return LottoType.findLottoType(this.numberofCount);
    }

    public boolean isWinning() {
        return MINIMUM_VALUE <= this.numberofCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
