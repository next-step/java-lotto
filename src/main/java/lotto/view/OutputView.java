package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Rank;
import lotto.dto.RankResult;

public class OutputView {

    public static void renderingLottos(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void renderingWinningStatistics(RankResult result) {
        LottoRank[] values = LottoRank.values();
        for (LottoRank lottoRank : values) {
            int matchCount = lottoRank.count();
            int price = lottoRank.price();
            int winningCount = result.count(lottoRank);
            System.out.println(String.format("%d개 일치 (%d원)- %d개", matchCount, price, winningCount));
        }
        System.out.printf("총 수익률은 %.2f입니다.\n", result.calcRate());
    }
}
