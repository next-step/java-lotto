package game.lotto.model;

import java.math.BigDecimal;

public class Report {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String LOSS_MESSAGE = "손해";
    public static final String SAME_MESSAGE = "본전";
    public static final String PROFIT_MESSAGE = "이익";

    private static final BigDecimal STANDARD = BigDecimal.ONE;

    private MatchResult matchResult;
    private Money money;

    public Report(MatchResult matchResult, Money money) {
        this.matchResult = matchResult;
        this.money = money;
    }

    public String makeStringReport() {
        StringBuilder report = new StringBuilder();
        report.append("당첨 통계").append(LINE_SEPARATOR);
        report.append("---------").append(LINE_SEPARATOR);
        for (Rank rank : Rank.values()) {
            if (rank.isMiss()) {
                continue;
            }
            appendMatch(report, rank);
        }
        BigDecimal earningRate = money.computeEarningRate(matchResult.getTotalPrize());
        report.append(
                String.format(
                        "총 수익률은 %.2f 입니다.(기준이 %d이기 때문에 결과적으로 %s라는 의미임)"
                        , earningRate.floatValue()
                        , STANDARD.intValue()
                        , getEarningMessage(earningRate)
                )
        );

        return report.toString();
    }

    private StringBuilder appendMatch(StringBuilder stringBuilder, Rank rank) {
        stringBuilder.append(rank.getMessage()).append(" - ").append(matchResult.getMatch(rank).getCount()).append("개").append(LINE_SEPARATOR);
        return stringBuilder;
    }

    public String getEarningMessage(BigDecimal earningRate) {
        if (isGraterRate(earningRate)) {
            return PROFIT_MESSAGE;
        }

        if (isLowerRate(earningRate)) {
            return LOSS_MESSAGE;
        }

        return SAME_MESSAGE;
    }

    private boolean isLowerRate(BigDecimal earningRate) {
        return STANDARD.compareTo(earningRate) > 0;
    }

    private boolean isGraterRate(BigDecimal earningRate) {
        return STANDARD.compareTo(earningRate) < 0;
    }
}
