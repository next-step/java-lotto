package domain;

import java.util.*;

public class Lotto {

    private List<Integer> sixNumbers;

    public Lotto(List<Integer> sixNumbers) {
        Objects.requireNonNull(sixNumbers);
        this.sixNumbers = sixNumbers;
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }

    public Long countMatching(List<Integer> winningNumbers) {
        return winningNumbers.stream().filter(sixNumbers::contains).count();
    }
}
