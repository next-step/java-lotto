package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Rank;

public class OutputView {

    public static void renderingLottos(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void renderingWinningStatistics(List<Rank> result) {
        LottoRank[] values = LottoRank.values();
        for (LottoRank lottoRank : values) {
            int matchCount = lottoRank.count();
            int price = lottoRank.price();
            int winningCount = (int) result.stream().filter(r -> r.equals(lottoRank)).count();
            System.out.println(String.format("%d개 일치 (%d원)- %d개", matchCount, price, winningCount));
        }
        double statistics = calcPrice(result) / (double) (result.size() * 1000);
        System.out.printf("총 수익률은 %.2f입니다.\n", statistics);
    }

    private static int calcPrice(List<Rank> result) {
        return result.stream().mapToInt(Rank::price).sum();
    }
}
