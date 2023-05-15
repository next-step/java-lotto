package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    int number;

    public LottoNumber(int inNumber) {
        validateRange(inNumber);
        this.number = inNumber;
    }

    private void validateRange(int inNumber) {
        if (inNumber < MIN_NUMBER || inNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("Number must be between %d and %d.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    public static List<LottoNumber> getAvailableLottoNumbers() {
        List<LottoNumber> availableNumbers = new ArrayList<>();

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            availableNumbers.add(new LottoNumber(i));
        }

        return availableNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber that = (LottoNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber compareLottoNumber) {
        return Integer.compare(this.number, compareLottoNumber.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
