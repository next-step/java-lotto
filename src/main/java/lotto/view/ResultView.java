package lotto.view;

import lotto.model.Lotto;
import lotto.model.enums.MatchingStrategy;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static String STATISTIC_FORMAT = "%s개 일치 (%s원)- %s개";
    private static String STATISTIC_BONUS_FORMAT = "%s개 일치, 보너스 볼 일치(%s원)- %s개";
    private static String PROFIT_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static String SHOW_GAME_COUNT_FORMAT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";

    public static void showWinningStatistics(Map<MatchingStrategy, List<Lotto>> results) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<MatchingStrategy, List<Lotto>> entry : results.entrySet()) {
            System.out.println(showStatistics(entry.getKey(), entry.getValue().size()));
        }
    }

    public static void showAllTickets(List<Lotto> games) {
        games.forEach(g -> System.out.println(g.toString()));
        System.out.println();
    }

    public static String showStatistics(MatchingStrategy matchingStrategy, int count) {
        return String.format(matchingStrategy != MatchingStrategy.FIVE_WITH_BONUS ? STATISTIC_FORMAT : STATISTIC_BONUS_FORMAT,
                matchingStrategy.getCount(),
                matchingStrategy.getReword(),
                count);
    }

    public static void showProfit(Map<MatchingStrategy, List<Lotto>> results, int input) {
        int result = 0;
        for (Map.Entry<MatchingStrategy, List<Lotto>> entry : results.entrySet()) {
            result += entry.getKey().getReword() * entry.getValue().size();
        }
        System.out.println(String.format(PROFIT_FORMAT, result / input * 100));
    }

    public static void showLottoCountInfo(int manualLottoCount, int autoLottoCount) {
        System.out.println(String.format(
                SHOW_GAME_COUNT_FORMAT, manualLottoCount, autoLottoCount));
    }
}
