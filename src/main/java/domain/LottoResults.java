package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResults {
    public static final int MINIMUM_HIT_NUMBER = 3;

    private List<LottoResult> prizes;

    public LottoResults() {
        this.prizes = Arrays.stream(Prize.values())
                .map(it -> new LottoResult(it, 0))
                .collect(Collectors.toList());
    }

    public void win(int hitNumber) {
        if (hitNumber < MINIMUM_HIT_NUMBER) {
            return;
        }

        for (LottoResult prize : prizes) {
            prize.winning(hitNumber);
        }
    }

    public List<LottoResult> getPrizes() {
        return this.prizes;
    }

    public int getTotalPrizeMoney() {
        int result = 0;
        for (LottoResult prize : prizes) {
            result += prize.calculateWinningMoney();
        }
        return result;
    }
}
