package lottery.domain;

import java.util.List;

public class LotteryResult {
    private final List<Integer> winNumbers;

    public LotteryResult(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }
}
