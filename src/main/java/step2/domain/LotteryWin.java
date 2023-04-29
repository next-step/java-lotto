package step2.domain;

import java.util.List;
import java.util.Map;

public class LotteryWin {

    private final WinningNumbers winningNumbers;
    private final Results results;

    private static final int FOURTH = 3;
    private static final int THIRD = 4;
    private static final int SECOND = 5;
    private static final int FIRST = 6;


    public LotteryWin(WinningNumbers winningNumbers) {
        this.results = new Results();
        this.winningNumbers = winningNumbers;
    }


    public void confirm(List<Lotto> numbers) {
        for (Lotto number : numbers) {
            check(number.getNumbers());
        }
    }

    public Map<Integer, Integer> getResult(){
        return this.results.get();
    }


    public int getWinningAmount() {
        return results.sum();
    }

    private void check(List<Integer> numbers) {
        int matchedCount = getMatchedCount(numbers);

        if (matchedCount == FOURTH) {
            results.add(matchedCount);
            return;
        }

        if (matchedCount == THIRD) {
            results.add(matchedCount);
            return;
        }

        if (matchedCount == SECOND) {
            results.add(matchedCount);
            return;
        }

        if (matchedCount == FIRST) {
            results.add(matchedCount);
        }
    }

    private int getMatchedCount(List<Integer> numbers) {
        return (int) numbers.stream().filter(this.winningNumbers::confirm).count();
    }
}
