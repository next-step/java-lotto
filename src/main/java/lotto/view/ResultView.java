package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.Prize;
import lotto.util.Reporter;

import java.util.Map;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.getSize());
        System.out.println(lottos);
        System.out.println();
    }

    public static void printReport(Lottos lottos, Lotto winningNumbers) {
        Map<Integer, Integer> matchNums = lottos.getMatchNums(winningNumbers);

        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (Prize prize : Prize.values()) {
            sb.append(prize.number()).append("개 일치 (")
                    .append(prize.money())
                    .append("원)- ")
                    .append(matchNums.getOrDefault(prize.number(), 0))
                    .append("개)\n");
        }
        sb.append("총 수익률은 ").append(Reporter.getROI(matchNums, lottos.getSize())).append("입니다\n");
        System.out.println(sb);
    }
}
