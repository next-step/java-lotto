package lotto.view;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import java.util.stream.Collectors;
import lotto.domain.Prize;
import lotto.domain.WinningResults;

public class ConsoleOutput {

    public static void printLottoCount(final int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(LottoList lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String output = lotto.getLottoNumbers().stream()
                    .map(lottoNumber -> lottoNumber.getValue().toString())
                    .collect(Collectors.joining(", "));

            System.out.println(output);
        }

        System.out.println();
    }

    public static void printWinningStatistics(WinningResults winningResults) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Set<Prize> reversedKeyPrizes= new TreeSet<>(Collections.reverseOrder());
        reversedKeyPrizes.addAll(winningResults.keySet());

        for (Prize prize : reversedKeyPrizes) {
            String output = String.format(
                "%d개 일치(%d원)-%d개",
                prize.getMatchingCount(),
                prize.getMoney(),
                winningResults.get(prize).getMatchCount());

            System.out.println(output);
        }

        System.out.println();
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.2f입니다", earningsRate);

        if (earningsRate < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
