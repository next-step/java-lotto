package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final LottoTicket winnerNumbers;
    private int bonusNumber = 0;

    public WinnerNumbers(List<Integer> generatedNumbers) {
        this.winnerNumbers = new LottoTicket(generatedNumbers);
    }

    public WinnerNumbers(List<Integer> generatedNumbers, int bonusNumber) {
        this.winnerNumbers = new LottoTicket(generatedNumbers);
        this.bonusNumber = bonusNumber;
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

    public List<Integer> printWinnerNumbers() {
        return this.winnerNumbers.printLottoNumbers();
    }
}
