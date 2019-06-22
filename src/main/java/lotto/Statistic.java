package lotto;

public class Statistic {

    private final WinInfo winInfo;
    private final long prizeCount;

    public Statistic(WinInfo winInfo, long prizeCount) {

        this.winInfo = winInfo;
        this.prizeCount = prizeCount;
    }

    public int getMatchCount() {

        return winInfo.getMatchCount();
    }

    public int getPrizeMoney() {

        return winInfo.getPrizeMoney();
    }

    public long getPrizeCount() {

        return prizeCount;
    }

    public long getEarnMoney() {
        return getPrizeMoney() * getPrizeCount();
    }
}
