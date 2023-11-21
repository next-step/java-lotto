package lotto.domain;

import java.util.List;

public class WinningNumber {

    private List<String> numbers;
    private int bonusNumber;

    public WinningNumber(List<String> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchNumbers(Lotto lotto) {
        boolean matchCheck;
        int answerCount = 0;
        for (String number : numbers) {
            matchCheck = lotto.getLotto().stream().anyMatch(num -> num.getNumber() == Integer.parseInt(number));
            answerCount = answerCalc(matchCheck, answerCount);
        }

        return answerCount;
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getLotto().stream().anyMatch(num -> num.getNumber() == bonusNumber);
    }

    private int answerCalc(boolean checkContains, int answerCount) {
        if (checkContains) {
            answerCount++;
        }
        return answerCount;
    }

}
