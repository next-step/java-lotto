package lotto.domain;

public class Statistic {

    private final PrizeInfo prizeInfo;
    private final long prizeCount;

    public Statistic(PrizeInfo prizeInfo, long prizeCount) {

        this.prizeInfo = prizeInfo;
        this.prizeCount = prizeCount;
    }

    public int getMatchCount() {

        return prizeInfo.getMatchCount();
    }

    public int getPrizeMoney() {

        return prizeInfo.getPrizeMoney();
    }

    public long getPrizeCount() {

        return prizeCount;
    }

    public long getEarnMoney() {
        return getPrizeMoney() * getPrizeCount();
    }
}
