package lotto.step3.view;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.LottoStore;
import lotto.step3.domain.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderLottoNumber(Lotteries lotteries) {
        lotteries.getLotteries().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printOrderLottoCount(int manualCount, LottoStore store) {
        int autoCount=  store.calculateAutoCount(manualCount);
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
    }

    public static void printLottoStatics(Map<Rank, Integer> lottoStatistics, double profit) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계");
        builder.append("\n");
        builder.append("----------");
        builder.append("\n");
        List<Rank> ranks = Arrays.asList(Rank.values());
        ranks.sort(Collections.reverseOrder());
        for (int i = 1; i < ranks.size(); i++) {
            builder.append(ranks.get(i).getCountOfMatch());
            builder.append("개 일치");
            isSecondPrize(builder, ranks.get(i));
            builder.append("(");
            builder.append(ranks.get(i).getPrizeMoney());
            builder.append("원) - ");
            isRanker(builder, lottoStatistics, ranks.get(i));
            builder.append("개");
            builder.append("\n");
        }
        System.out.print(builder);
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

    private static void isSecondPrize(StringBuilder builder, Rank rank) {
        if (rank == Rank.SECOND) {
            builder.append(", 보너스볼 일치 ");
        }
    }

    private static void isRanker(StringBuilder builder, Map<Rank, Integer> lottoStatistics, Rank rank) {
        if (lottoStatistics == null || lottoStatistics.get(rank) == null) {
            builder.append(0);
            return;
        }
        builder.append(lottoStatistics.get(rank));
    }

}
