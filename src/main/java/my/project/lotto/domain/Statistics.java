package my.project.lotto.domain;

import my.project.constants.Rule;

import java.util.List;

public class Statistics {
    public static final int FIRST_PRICE = 2000000000;
    private final StatRecord statRecord;

    public Statistics() {
        statRecord = new StatRecord();
    }

    public StatRecord analyze(StatInfo info) {
        rank(info);
        profit(info);
        return this.statRecord;
    }

    private void rank(StatInfo info) {
        List<GameRecord> records = info.getRecords();
        for (GameRecord record : records) {
            Win rank = Win.findRank(record, info.getWinningNumber());
            statRecord.setRank(rank);
        }
    }

    private void profit(StatInfo info) {
        statRecord.setProfit(
                (double) ((Lotto.FIRST_PRICE * statRecord.getFirst())
                        + (Lotto.THIRD_PRICE * statRecord.getThird())
                        + (Lotto.FOURTH_PRICE * statRecord.getFourth())
                        + (Lotto.FIFTH_PRICE * statRecord.getFifth()))
                        / info.getMoney());
    }

}
