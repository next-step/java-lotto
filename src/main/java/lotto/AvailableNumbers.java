package lotto;

import util.Number;

import java.util.Collections;
import java.util.List;

public class AvailableNumbers {
    private final List<Integer> availableNumbers;

    public AvailableNumbers(int minNumber, int maxNumber) {
        if (minNumber < 0) {
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
