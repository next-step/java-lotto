package lotto.domain;

import java.util.Collections;
import java.util.List;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryTicket {

    private final List<Integer> numbers;

    public LotteryTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public WinningRanking getRankByMatchNumbers(List<Integer> winningNumbers) {
        int matchingCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return WinningRanking.getByMatchingCount(matchingCount);
    }
}
