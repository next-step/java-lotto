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
//        List<Lotto_> records = info.getRecords();
//        for (Lotto_ record : records) {
////            Win rank = Win.findRank(record, info.getWinningNumber());
////            statRecord.setRank(rank);
//        }
    }

    private void profit(StatInfo info) {
//        statRecord.setProfit(
//                (double) ((Money.FIRST_PRICE * statRecord.getFirst())
//                        + (Money.THIRD_PRICE * statRecord.getThird())
//                        + (Money.FOURTH_PRICE * statRecord.getFourth())
//                        + (Money.FIFTH_PRICE * statRecord.getFifth()))
//                        / info.getMoney());
    }

}
