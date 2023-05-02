package lotto.view;

import lotto.model.Lotto;
import lotto.model.enums.Ranking;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static String STATISTIC_FORMAT = "%s개 일치 (%s원)- %s개";
    private static String PROFIT_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void showWinningStatistics(Map<Ranking, List<Lotto>> results){
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<Ranking, List<Lotto>> entry:results.entrySet()) {
            System.out.println(showStatistics(entry.getKey(), entry.getValue().size()));
        }
    }

    public static String showStatistics(Ranking ranking, int count){
        return String.format(STATISTIC_FORMAT,
                        ranking.getCount(),
                        ranking.getReword(),
                        count);
    }

    public static void showProfit(Map<Ranking, List<Lotto>> results, int input){
        int result = 0;
        for (Map.Entry<Ranking, List<Lotto>> entry:results.entrySet()) {
            result += entry.getKey().getReword() * entry.getValue().size();
        }
        System.out.println(
                String.format(PROFIT_FORMAT, result/input)
        );
    }

}
