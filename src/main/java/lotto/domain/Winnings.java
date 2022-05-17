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

    private RecordMatched recordMatched;

    public Winnings(String[] winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
        this.recordMatched = new RecordMatched(Matched.values().length);
    }

    public Winnings(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
        this.recordMatched = new RecordMatched(Matched.values().length);
    }

    public void countMatchedNumbers(Lotto lotto) {
        int matchedNumber = 0;
        for (LottoNumber number : winningNumbers.winningNumbers()) {
            matchedNumber += lotto.hasNumbers(number) ? 1 : 0;
        }
        Matched matched = Matched.valueOf(matchedNumber, lotto.hasNumbers(winningNumbers.bonusNumber()));
        recordNumberOfMatched(matched.index());
    }

    private void recordNumberOfMatched(int index) {
        this.recordMatched = this.recordMatched.addByMatchedIndex(index);
    }

    public int winningsRewards() {
        int winningsRewards = 0;
        Matched[] matcheds = Matched.values();
        for (int i = 0; i < recordMatched.recordMatched().length; i++) {
            winningsRewards += recordMatched.recordMatched()[i] * matcheds[i].reward();
        }
        return winningsRewards;
    }

    public int[] recordMatched() {
        return recordMatched.recordMatched();
    }
}
