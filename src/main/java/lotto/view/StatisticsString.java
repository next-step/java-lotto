package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottosStatistics;

public class StatisticsString {

    LottosStatistics lottosStatistics;

    private StatisticsString(LottosStatistics lottosStatistics) {
        this.lottosStatistics = lottosStatistics;
    }

    public static StatisticsString of(LottosStatistics lottosStatistics) {
        return new StatisticsString(lottosStatistics);
    }

    private String getLottoRankString(LottoRank lottoRank) {
        return new StringBuilder()
                .append(lottoRank.getMatchCount())
                .append("개 일치")
                .append(lottoRank.isBonus() ? ", 보너스 볼 일치" : " ")
                .append("(")
                .append(lottoRank.getWinningAmount())
                .append(")").toString();
    }

    public String getWinningCountString(LottoRank lottoRank) {
        return getLottoRankString(lottoRank) + " - " + lottosStatistics.getWinningCount(lottoRank);
    }

    public String getStringRateOfReturnAmount() {
        return new StringBuilder().append("총 수익률은 ")
                .append(lottosStatistics.getRateOfReturnAmount())
                .append("입니다. ")
                .append("(기준이 1이기 때문에 결과적으로 ")
                .append(lottosStatistics.getRateOfReturnAmount() > 1 ? "이득이 " : "손해")
                .append("라는 의미임)").toString();
    }
}
