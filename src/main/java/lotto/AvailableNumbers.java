package lotto;

import util.Number;

import java.util.Collections;
import java.util.List;

public class AvailableNumbers {
    private static final int MIN_VALUE = 0;

    private final List<Integer> availableNumbers;

    public AvailableNumbers(int minNumber, int maxNumber) {
        if (minNumber < MIN_VALUE) {
            throw new IllegalArgumentException("You cannot enter a negative number for the minimum value.");
        }
        this.availableNumbers = Number.rangeNumber(minNumber, maxNumber);
    }

    public List<Integer> subList(int startIndex , int endIndex) {
        return this.availableNumbers.subList(startIndex, endIndex);
    }

    public void shuffle() {
        Collections.shuffle(this.availableNumbers);
    }
}
