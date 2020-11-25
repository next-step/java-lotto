package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Map;

public class Lotto {
    private final Cash price;
    private final PrizeInfo prizeInfo;

    public Lotto(Cash price, PrizeInfo prizeInfo) {
        this.price = price;
        this.prizeInfo = prizeInfo;
    }

    public Cash getPrice() {
        return price;
    }


    public Rank checkRank(Pick pick, LottoBalls winningBalls) {
        return this.prizeInfo.checkRank(pick, winningBalls);
    }

    public Map<Rank, Prize> getPrizeMap() {
        return prizeInfo.getPrizeMap();
    }
}
