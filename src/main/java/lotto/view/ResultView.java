package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLottos(Lottos manualLottos, Lottos autoLottos) {
        StringBuilder sb = new StringBuilder();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.size(), autoLottos.size());

        for (Lotto lotto : manualLottos.merged(autoLottos).values()) {
            sb.append(lotto.numbers().stream()
                    .map(Number::value)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printReport(Ranks ranks, float roi) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (Rank rank : Rank.values()) {
            sb.append(rank.countOfMatch()).append("개 일치");
            if (rank.equals(Rank.SECOND)) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (")
                .append(rank.winningMoney())
                .append("원)- ")
                .append(ranks.values().stream()
                        .filter(r -> r.equals(rank))
                        .count())
                .append("개)\n");
        }

        sb.append("총 수익률은 ").append(roi).append("입니다\n");
        System.out.println(sb);
    }
}
