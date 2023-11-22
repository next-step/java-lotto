package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.RankLotto;
import lotto.domain.StatisticsWinnerResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void print(String result) {
        System.out.println(result);
    }

    public static void resultPrint(double rateOfReturn) {
        StringBuilder reteReturnPrint = new StringBuilder();
        reteReturnPrint.append("총 수익률은 ");
        reteReturnPrint.append(rateOfReturn);
        reteReturnPrint.append("입니다.");
        if (rateOfReturn < 1) {
            reteReturnPrint.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        print(reteReturnPrint.toString());
    }

    public static void winnigStatisticsPrintString(StatisticsWinnerResult winnerResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        sb.append(winnerResult.result()
                .entrySet().stream().filter(entry -> entry.getKey() != RankLotto.MISS)
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .map(entry -> String.format("%s - %d개", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n")));
        print(sb.toString());
    }

    public static void purchsePrint(int manualCount, int autoCount) {
        print(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount));
    }

    public static void lottosNumberPrint(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }
}
