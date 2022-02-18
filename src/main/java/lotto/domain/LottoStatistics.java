package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final List<Rank> lottoStatistics;

    public LottoStatistics(List<Rank> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public String getLottoEarningRate(LottoPrice lottoPrice) {
        int totalPrice = 0;
        for (Rank statistics : lottoStatistics) {
            totalPrice += statistics.getMoney();
        }
        return String.format("%.2f", BigDecimal.valueOf(totalPrice).divide(
            BigDecimal.valueOf(lottoPrice.getPrice())));
    }

    public Map<Rank, Integer> makeRankReport() {
        Map<Rank, Integer> rankReport = new LinkedHashMap<>();
        rankReport.put(Rank.FIFTH, 0);
        rankReport.put(Rank.FOURTH, 0);
        rankReport.put(Rank.THIRD, 0);
        rankReport.put(Rank.SECOND, 0);
        rankReport.put(Rank.FIRST, 0);

        for(Rank rank : lottoStatistics) {
            rankReport.put(rank, rankReport.getOrDefault(rank,0) + 1);
        }
//        Map<Integer, Integer> rankReport = new LinkedHashMap<>();
//        rankReport.put(3,0);
//        rankReport.put(4,0);
//        rankReport.put(5,0);
//        rankReport.put(7,0);
//        rankReport.put(6,0);
//        for (Rank rank : lottoStatistics) {
//            rankReport.put(rank.getGrade(), rankReport.getOrDefault(rank.getGrade(), 0) + 1);
//        }
        return rankReport;
    }

    public List<Rank> getLottoStatistics() {
        return lottoStatistics;
    }

}
