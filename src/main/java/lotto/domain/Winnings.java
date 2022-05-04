package lotto.domain;

import lotto.util.StringUtils;

import java.util.List;

public class Winnings {

    private final int MATCHED_THREE = 3;
    private final int MATCHED_FOUR = 4;
    private final int MATCHED_FIVE = 5;
    private final int MATCHED_ALL = 6;

    private final int REWARD_NONE = 0;
    private final int REWARD_MATCHED_THREE = 5000;
    private final int REWARD_MATCHED_FOUR = 50000;
    private final int REWARD_MATCHED_FIVE = 1500000;
    private final int REWARD_MATCHED_ALL = 2000000000;

    private final StringUtils stringUtils = new StringUtils();

    private List<Integer> winningNumbers;

    private int[] recordMatched;

    private int[] rewards = {
            REWARD_NONE, REWARD_NONE, REWARD_NONE,
            REWARD_MATCHED_THREE, REWARD_MATCHED_FOUR, REWARD_MATCHED_FIVE, REWARD_MATCHED_ALL};

    public Winnings(String[] winningNumbers) {
        StringUtils stringUtils = new StringUtils();
        this.winningNumbers = stringUtils.stringArrayToIntArray(winningNumbers);
        this.recordMatched = new int[7];
    }

    public Winnings(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.recordMatched = new int[7];
    }

    public int countMatchedNumbers(List<Integer> numbers) {
        int matchedNumber = 0;
        for (int number : numbers) {
            matchedNumber += checkNumber(number);
        }
        recordNumberOfMatched(matchedNumber);
        return matchedNumber;
    }

    private int checkNumber(int number) {
        if (winningNumbers.contains(number)) {
            return 1;  
        }
        return 0;
    }

    private void recordNumberOfMatched(int matchedNumber) {
        switch (matchedNumber) {
            case MATCHED_THREE:
                this.recordMatched[MATCHED_THREE]++;
                break;
            case MATCHED_FOUR:
                this.recordMatched[MATCHED_FOUR]++;
                break;
            case MATCHED_FIVE:
                this.recordMatched[MATCHED_FIVE]++;
                break;
            case MATCHED_ALL:
                this.recordMatched[MATCHED_ALL]++;
                break;
        }
    }

    public int winningsRewards() {
        int winningsRewards = 0;
        for (int i = 3; i < recordMatched.length; i++) {
            winningsRewards += recordMatched[i] * rewards[i];
        }
        return winningsRewards;
    }

    public int[] recordMatched() {
        return recordMatched;
    }

    public int[] rewards() {
        return rewards;
    }
}
