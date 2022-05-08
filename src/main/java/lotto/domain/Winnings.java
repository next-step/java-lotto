package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winnings {

    private static final int REWARD_NONE = 0;
    private static final int REWARD_MATCHED_THREE = 5000;
    private static final int REWARD_MATCHED_FOUR = 50000;
    private static final int REWARD_MATCHED_FIVE = 1500000;
    private static final int REWARD_MATCHED_ALL = 2000000000;

    private final WinningNumbers winningNumbers;

    private final int[] recordMatched;

    private final int[] rewards = {
            REWARD_NONE, REWARD_NONE, REWARD_NONE,
            REWARD_MATCHED_THREE, REWARD_MATCHED_FOUR, REWARD_MATCHED_FIVE, REWARD_MATCHED_ALL};

    public Winnings(String[] winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(parseWinningNumbers(winningNumbers), bonusNumber);
        this.recordMatched = new int[Matched.values().length];
    }

    public Winnings(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
        this.recordMatched = new int[Matched.values().length];
    }

    public void countMatchedNumbers(List<Integer> numbers) {
        int matchedNumber = 0;
        for (int number : numbers) {
            matchedNumber += winningNumbers.checkNumber(number);
        }
        recordNumberOfMatched(matchedNumber);
    }

    private void recordNumberOfMatched(int matchedNumber) {
        this.recordMatched[matchedNumber]++;
    }

    public int winningsRewards() {
        int winningsRewards = 0;
        for (int i = 3; i < recordMatched.length; i++) {
            winningsRewards += recordMatched[i] * rewards[i];
        }
        return winningsRewards;
    }

    private List<Integer> parseWinningNumbers(String[] strings) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String string : strings) {
            winningNumbers.add(Integer.parseInt(string));
        }

        return winningNumbers;
    }

    public int[] recordMatched() {
        return recordMatched;
    }

    public int[] rewards() {
        return rewards;
    }
}
