package lotto.view;

import lotto.domain.RankLotto;
import lotto.domain.StatisticsWinnerResult;

import java.util.stream.Collectors;

public class ResultView {

    public static void print(String result) {
        System.out.println(result);
    }

    public static void resultPrint(double rateOfReturn) {

        print(String.format("총 수익률은 %.2f 입니다.", rateOfReturn));
        if (rateOfReturn < 1) {
            print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static void winnigStatisticsPrintString(StatisticsWinnerResult winnerResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        sb.append(winnerResult.result()
                .entrySet().stream().filter(entry -> entry.getKey() != RankLotto.MISS)
                .map(entry -> String.format("%s - %d개", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n")));
        print(sb.toString());
    }
}
