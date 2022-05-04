package lotto.domain;

import lotto.util.StringUtils;

import java.util.List;

public class Winnings {

    private final StringUtils stringUtils = new StringUtils();

    private List<Integer> winningNumbers;

    public Winnings(String[] winningNumbers) {
        StringUtils stringUtils = new StringUtils();
        this.winningNumbers = stringUtils.stringArrayToIntArray(winningNumbers);
    }

    public Winnings(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int countMatchedNumbers(List<Integer> numbers) {
        int matchedNumber = 0;
        for (int number : numbers) {
            matchedNumber += checkNumber(number);
        }
        return matchedNumber;
    }

    private int checkNumber(int number) {
        if (winningNumbers.contains(number)) {
            return 1;  
        }
        return 0;
    }
}
