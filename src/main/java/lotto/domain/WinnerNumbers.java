package lotto.domain;

import java.util.*;

public class WinnerNumbers {
    private final List<Integer> winnerNummbers = new ArrayList<>();

    public WinnerNumbers(List<Integer> generatedNumbers) {
        winnerNummbers.addAll(generatedNumbers);
    }

    @Override
    public String toString() {
        return this.winnerNummbers.toString();
    }

    public boolean isContain(int number) {
        return winnerNummbers.contains(number);
    }
}
