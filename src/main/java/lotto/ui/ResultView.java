package lotto.ui;

import lotto.domain.matcher.LottoMatcher;
import lotto.domain.matcher.LottoGameResults;

import static lotto.domain.matcher.LottoRank.*;

public class ResultView {
    private static final String RESULT_SUMMARY_MESSAGE = "당첨 통계";
    private static final String CARRIAGE_RETURN = "\n";
    private static final String DIVISION_LINE = "---------";
    private static final String MATCH_COMMON_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String NET_PROFIT_MESSAGE =
            "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void print(LottoMatcher lottoMatcher) {
        lottoMatcher.getTicketSources()
                .forEach(System.out::println);
    }

    public static void print(LottoGameResults results) {
        initMessage();
        printWinningResults(results);
        String profitMessage = String.format(NET_PROFIT_MESSAGE, results.getProfitRate());
        stringBuilder.append(profitMessage);

        System.out.println(stringBuilder.toString());
    }

    private static void initMessage() {
        stringBuilder.append(RESULT_SUMMARY_MESSAGE)
                .append(CARRIAGE_RETURN)
                .append(DIVISION_LINE)
                .append(CARRIAGE_RETURN);
    }

    private static void printWinningResults(LottoGameResults lottoGameResults) {
        stringBuilder.append(getThreeMatchResults(lottoGameResults) + CARRIAGE_RETURN);
        stringBuilder.append(getFourMatchResults(lottoGameResults) + CARRIAGE_RETURN);
        stringBuilder.append(getFiveMatchResults(lottoGameResults) + CARRIAGE_RETURN);
        stringBuilder.append(getSixMatchResults(lottoGameResults) + CARRIAGE_RETURN);
    }

    private static String getThreeMatchResults(LottoGameResults lottoGameResults) {
        long three = lottoGameResults.getEachRankCountTotal(THREE);
        return String.format(MATCH_COMMON_MESSAGE, THREE.getMatchCount(), THREE.getWinningPrize(), three);
    }

    private static String getFourMatchResults(LottoGameResults lottoGameResults) {
        long four = lottoGameResults.getEachRankCountTotal(FOUR);
        return String.format(MATCH_COMMON_MESSAGE, FOUR.getMatchCount(), FOUR.getWinningPrize(), four);
    }

    private static String getFiveMatchResults(LottoGameResults lottoGameResults) {
        long five = lottoGameResults.getEachRankCountTotal(FIVE);
        long fiveBonus = lottoGameResults.getEachRankCountTotal(FIVE_BONUS);
        String fiveMatch = String.format(MATCH_COMMON_MESSAGE, FIVE.getMatchCount(), FIVE.getWinningPrize(), five);
        String fiveBonusMatch = String.format(MATCH_BONUS_MESSAGE, FIVE.getMatchCount(), FIVE_BONUS.getWinningPrize(), fiveBonus);
        return fiveMatch + CARRIAGE_RETURN + fiveBonusMatch;
    }

    private static String getSixMatchResults(LottoGameResults lottoGameResults) {
        long six = lottoGameResults.getEachRankCountTotal(SIX);
        return String.format(MATCH_COMMON_MESSAGE, SIX.getMatchCount(), SIX.getWinningPrize(), six);
    }

    public static void print(ResponseDto responseDto) {

    }
}
