package lotto.view;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size()).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos.values()) {
            sb.append(lotto.values().stream()
                    .map(Number::value)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printReport(LottoResult lottoResult) {
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
                .append(lottoResult.ranks().values().stream()
                        .filter(r -> r.equals(rank))
                        .count())
                .append("개)\n");
        }

        sb.append("총 수익률은 ").append(lottoResult.roi()).append("입니다\n");
        System.out.println(sb);
    }
}
