package lotto.presentation;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRank;
import lotto.domain.UserLottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printPurchaseCount(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String lottoString = lotto.getLottoNumbers().stream()
                    .map(number -> Integer.toString(number))
                    .collect(Collectors.joining(", "));

            System.out.println("[" + lottoString + "]");
        }
        System.out.println();
    }

    public void printLottoResult(UserLottoResult userLottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoWinningRank lottoWinningRank : LottoWinningRank.values()) {
            System.out.printf("%d개 일치 : (%d원)- %d개\n", lottoWinningRank.getMatchCount(), lottoWinningRank.getWinningPrice(), userLottoResult.getCountLottoResult(lottoWinningRank));
        }
        System.out.printf("총 수익률은 %.2f\n", userLottoResult.getRateOfReturn());
    }
}
