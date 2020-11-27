package lotto.automatic.view;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.LottoMoney;
import lotto.automatic.domain.LottoRank;
import lotto.automatic.domain.LottoResult;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {

        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for(Lotto lotto: lottos) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public void printLottoResult(LottoMoney lottoMoney, LottoResult result) {

        System.out.println("당첨 통계");
        System.out.println("---------");

        Stream.of(LottoRank.FORTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
                .forEach(r -> printRankCount(r, result.getRankCount(r)));

        System.out.printf("총 수익률은 %.2f입니다.\n", lottoMoney.calculateEarningRate(result.getEarningMoney()));
    }

    private void printRankCount(LottoRank rank, int count) {

        System.out.printf("%d개 일치 (%d)원 - %d개\n", rank.matchCount, rank.earningMoney, count);
    }
}
