package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Number> pickedNumbers;

    public Lotto(List<Number> pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public long match(List<Number> winningNumber) {
        return winningNumber.stream()
                            .filter(pickedNumbers::contains)
                            .count();
    }
}
