package my.project.lotto.domain;

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
        List<Lotto> records = info.getRecords();
        for (Lotto record : records) {
//            Win rank = Win.findRank(record, info.getWinningNumber());
//            statRecord.setRank(rank);
        }
    }

    private void profit(StatInfo info) {
        statRecord.setProfit(
                (double) ((Lottos.FIRST_PRICE * statRecord.getFirst())
                        + (Lottos.THIRD_PRICE * statRecord.getThird())
                        + (Lottos.FOURTH_PRICE * statRecord.getFourth())
                        + (Lottos.FIFTH_PRICE * statRecord.getFifth()))
                        / info.getMoney());
    }

}
