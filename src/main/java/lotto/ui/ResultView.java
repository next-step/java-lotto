package lotto.ui;

import lotto.application.LottoResponse;
import lotto.application.LottoResults;
import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Lotto;
import lotto.domain.rank.LottoRanks;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lotto.domain.rank.LottoRank.*;

public class ResultView {
    private static final String RESULT_SUMMARY_MESSAGE = "당첨 통계";
    private static final String CARRIAGE_RETURN = "\n";
    private static final String DIVISION_LINE = "---------";
    private static final String MATCH_COMMON_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String COUNT_BY_MANUAL_AND_AUTO = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String NET_PROFIT_MESSAGE =
            "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void print(LottoResults lottoResults) {
        initMessage();
        printWinningResults(lottoResults);
        String profitMessage = String.format(NET_PROFIT_MESSAGE, lottoResults.getProfitRate());
        stringBuilder.append(profitMessage);

        System.out.println(stringBuilder.toString());
    }

    private static void initMessage() {
        stringBuilder.append(RESULT_SUMMARY_MESSAGE)
                .append(CARRIAGE_RETURN)
                .append(DIVISION_LINE)
                .append(CARRIAGE_RETURN);
    }

    public static void print(LottoResponse lottoManualResponse, LottoResponse lottoAutoResponse) {
        int manualCount = lottoManualResponse.size();
        int autoCount = lottoAutoResponse.size();
        System.out.println(String.format(COUNT_BY_MANUAL_AND_AUTO, manualCount, autoCount));
        printLotteries(lottoManualResponse);
        printLotteries(lottoAutoResponse);
    }

    private static void printLotteries(LottoResponse lottoResponse) {
        Lotteries lotteries = lottoResponse.getLottoResponse();
        List<String> lottoValues = getLottoValues(lotteries.getLotteries());
        lottoValues.forEach(System.out::println);
    }

    private static List<String> getLottoValues(List<Lotto> lotteries) {
        return lotteries.stream()
                .map(Lotto::toIntValues)
                .map(String::valueOf)
                .collect(toList());
    }

    private static void printWinningResults(LottoResults lottoResults) {
        stringBuilder.append(getThreeMatchResults(lottoResults.getLottoRanks()) + CARRIAGE_RETURN);
        stringBuilder.append(getFourMatchResults(lottoResults.getLottoRanks()) + CARRIAGE_RETURN);
        stringBuilder.append(getFiveMatchResults(lottoResults.getLottoRanks()) + CARRIAGE_RETURN);
        stringBuilder.append(getSixMatchResults(lottoResults.getLottoRanks()) + CARRIAGE_RETURN);
    }

    private static String getThreeMatchResults(LottoRanks lottoRanks) {
        long three = lottoRanks.getEachRankCountTotal(THREE);
        return String.format(MATCH_COMMON_MESSAGE, THREE.getMatchCount(), THREE.getWinningPrize(), three);
    }

    private static String getFourMatchResults(LottoRanks lottoRanks) {
        long four = lottoRanks.getEachRankCountTotal(FOUR);
        return String.format(MATCH_COMMON_MESSAGE, FOUR.getMatchCount(), FOUR.getWinningPrize(), four);
    }

    private static String getFiveMatchResults(LottoRanks lottoRanks) {
        long five = lottoRanks.getEachRankCountTotal(FIVE);
        long fiveBonus = lottoRanks.getEachRankCountTotal(FIVE_BONUS);
        String fiveMatch = String.format(MATCH_COMMON_MESSAGE, FIVE.getMatchCount(), FIVE.getWinningPrize(), five);
        String fiveBonusMatch = String.format(MATCH_BONUS_MESSAGE, FIVE.getMatchCount(), FIVE_BONUS.getWinningPrize(), fiveBonus);
        return fiveMatch + CARRIAGE_RETURN + fiveBonusMatch;
    }

    private static String getSixMatchResults(LottoRanks lottoRanks) {
        long six = lottoRanks.getEachRankCountTotal(SIX);
        return String.format(MATCH_COMMON_MESSAGE, SIX.getMatchCount(), SIX.getWinningPrize(), six);
    }

}
