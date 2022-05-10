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
        Matched matched = Matched.valueOf(matchedNumber, winningNumbers.checkBonus(numbers));
        recordNumberOfMatched(matched.index());
    }

    private void recordNumberOfMatched(int index) {
        this.recordMatched[index]++;
    }

    public int winningsRewards() {
        int winningsRewards = 0;
        Matched[] matcheds = Matched.values();
        for (int i = 0; i < recordMatched.length; i++) {
            winningsRewards += recordMatched[i] * matcheds[i].reward();
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
}
