package lotto.domain;

import java.util.*;

public class WinnerNumbers {
    private final List<Integer> winnerNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    public WinnerNumbers(List<Integer> generatedNumbers, Random random) {
        winnerNumbers.addAll(generatedNumbers);
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
        return this.winnerNumbers.toString();
    }

    public boolean isContain(int number) {
        return winnerNumbers.contains(number);
    }
}
