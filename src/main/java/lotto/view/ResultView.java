package lotto.view;

import lotto.Lotto;
import lotto.Rank;
import lotto.WinningLottos;

import java.util.List;

public class ResultView {

    public void printWinningStatics(WinningLottos winningLottos, Integer price) {
        System.out.printf("당첨 통계%n======%n");
        for (Rank rank : Rank.winningRanks()) {
            printWinningStatics(winningLottos, rank);
        }
        System.out.printf("총 수익률은 %.2f입니다.", winningLottos.investingPercent(price));
    }

    private void printWinningStatics(WinningLottos winningLottos, Rank rank) {
        System.out.printf("%d개%s 일치 (%d원) - %d개%n", rank.matchingCount(),
                Rank.SECOND.equals(rank) ? ", 보너스 볼 일치" : "", rank.rewardPrice(),
                winningLottos.countLottoByWinningNumber(rank));
    }

    public void printLottoCount(int count) {

    }

    public void printLottos(List<Lotto> lottos, int count) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.", count, lottos.size() - count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }
}
