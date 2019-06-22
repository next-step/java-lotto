package lotto.domain;

public class Statistic {

    private PrizeInfo prizeInfo;
    private long prizeCount;

    public static Statistic of(PrizeInfo prizeInfo, long prizeCount) {

        Statistic statistic = new Statistic();
        statistic.prizeInfo = prizeInfo;
        statistic.prizeCount = prizeCount;
        return statistic;
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
