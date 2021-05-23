package lotto.domains;

import lotto.enums.Payout;

public class LottoStatistic {
    private int count;
    private int payout;

    public LottoStatistic() {
        this.count = 0;
        this.payout = 0;
    }

    public void add(int matchNumber) {
        this.count++;
        this.payout += Payout.getPayout(matchNumber);
    }

    public int count() {
        return count;
    }

    public int payout() {
        return payout;
    }
}
