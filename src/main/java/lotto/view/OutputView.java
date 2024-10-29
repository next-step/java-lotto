package lotto.view;

import static lotto.domain.LottoRank.SECOND;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.RankResult;

public class OutputView {

    public static void renderingLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
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
            System.out.printf((creatFormat(lottoRank)) + "%n", matchCount, price, winningCount);
        }
        System.out.printf("총 수익률은 %.2f입니다.\n", result.calcRate());
    }

    private static String creatFormat(LottoRank rank) {
        if (SECOND.equals(rank)) {
            return "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
        }
        return "%d개 일치 (%d원)- %d개\n";
    }
}
