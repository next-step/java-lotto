package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.Rank;

import java.util.Map;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.getSize()).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos.values()) {
            sb.append(lotto.combine(", "));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printReport(Lottos lottos, Lotto winningNumbers) {
        Map<Integer, Integer> matchNums = lottos.getMatchNums(winningNumbers);

        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (Rank rank : Rank.values()) {
            sb.append(rank.countOfMatch()).append("개 일치 (")
                    .append(rank.winningMoney())
                    .append("원)- ")
                    .append(matchNums.getOrDefault(rank.countOfMatch(), 0))
                    .append("개)\n");
        }

        sb.append("총 수익률은 ").append(lottos.calculateROI(matchNums)).append("입니다\n");
        System.out.println(sb);
    }
}
