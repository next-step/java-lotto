package view;

import domain.Lotto;
import domain.LottoStatistics;
import domain.LottoResult;

import java.util.*;

public class LottoOutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public static void printLottoResult(LottoStatistics statistics) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");

        final Map<LottoResult, Long> lottoResultMap = statistics.groupAndCounting();

        LottoResult.findByWinning()
                .forEach(e -> builder.append(createLottoResult(e, Optional.ofNullable(lottoResultMap.get(e)).orElse(0L))));

        builder.append(String.format("총 수익률은 %.2f입니다.\n", statistics.getProfitRate()));

        System.out.println(builder);
    }

    private static String createLottoResult(LottoResult resultType, long count) {
        if (resultType == LottoResult.SECOND) {
            return String.format(String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개\n", resultType.matchCount(), resultType.winningMoney(), count));
        }

        return String.format("%d개 일치 (%d원) - %d개\n", resultType.matchCount(), resultType.winningMoney(), count);
    }
}
