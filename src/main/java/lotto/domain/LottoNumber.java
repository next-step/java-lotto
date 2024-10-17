package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final String DELIMITER = ", ";

    private final int number;

    public LottoNumber(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("Number must be between 0 and 45");
        }
        this.number = number;
    }

    public static List<LottoNumber> createWinningNumbers(final String winningNumber) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        String[] numbers = winningNumber.split(DELIMITER);
        for (String number : numbers) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }
        return winningNumbers;
    }

    public int countMatch(int countMatch, final LottoNumber winningNumber) {
        if (Objects.equals(this, winningNumber)) {
            countMatch += 1;
        }
        return countMatch;
    }

    public int countMatch(final List<LottoNumber> winningNumbers, int countMatch) {
        for (LottoNumber winningNumber : winningNumbers) {
            countMatch = this.countMatch(countMatch, winningNumber);
        }
        return countMatch;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
