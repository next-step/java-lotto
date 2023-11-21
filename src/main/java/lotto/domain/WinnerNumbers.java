package lotto.domain;

import java.util.*;

public class WinnerNumbers {
    private final List<Integer> winnerNummbers = new ArrayList<>();
    private int bonusNumber = 0;

    public WinnerNumbers(List<Integer> generatedNumbers, Random random) {
        winnerNummbers.addAll(generatedNumbers);
        while (bonusNumber != 0) {
            generateBonusNumber(random);
        }
    }

    private void generateBonusNumber(Random random) {
        int generatedBonusNum = random.nextInt(45) + 1;
        if (!isContain(generatedBonusNum)) {
            this.bonusNumber = generatedBonusNum;
        }
    }

    @Override
    public String toString() {
        return this.winnerNummbers.toString();
    }

    public boolean isContain(int number) {
        return winnerNummbers.contains(number);
    }
}
