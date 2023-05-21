package view;

import domain.Lotto;
import domain.LottoStatistics;
import domain.LottoResult;
import dto.LottoBuyResult;

import java.util.*;

public class LottoOutputView {
    public static void printLottoCount(LottoBuyResult autoLottoResult, List<Lotto> manualLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%n", manualLottoCount.size(), autoLottoResult.getLottos().size());
    }

    public static void printLottoList(LottoBuyResult result) {
        result.getLottos().forEach(System.out::println);
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

    public static void printInputManualLottoCount() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
