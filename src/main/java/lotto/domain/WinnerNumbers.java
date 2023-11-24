package lotto.domain;

import java.util.*;

public class WinnerNumbers {
    private LottoTicket winnerNumbers;
    private int bonusNumber = 0;

    public WinnerNumbers(List<Integer> generatedNumbers, Random random) {
        this.winnerNumbers = new LottoTicket(generatedNumbers);
//        while (bonusNumber == 0) {
//            generateBonusNumber(random);
//        }
    }

    public WinnerNumbers(List<Integer> generatedNumbers, int bonusNumber) {
        this.winnerNumbers = new LottoTicket(generatedNumbers);
        this.bonusNumber = bonusNumber;
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
        return winnerNumbers.isContain(number);
    }

    public int bonusNumber() {
        return this.bonusNumber;
    }

    public void throwBonusBall(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
