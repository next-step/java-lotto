package lotto.model;

import java.util.List;

public class Lotto {

    public static final int eachAmount = 1_000;

    private final List<Number> pickedNumbers;

    public Lotto(List<Number> pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public int match(List<Number> winningNumber) {
        return (int) winningNumber.stream()
                                  .filter(pickedNumbers::contains)
                                  .count();
    }

    @Override
    public String toString() {
        return String.valueOf(pickedNumbers);
    }
}
