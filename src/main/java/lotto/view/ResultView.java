package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Wallet;

public class ResultView {

    public void printLottoCount(Wallet wallet) {
        System.out.println(wallet.lottosCount() + "개를 구매했습니다.");
    }

    public void printLottosNumber(Wallet wallet) {
        System.out.println(wallet.lottos().AllLottos());
    }

    public void printLottoResult(LottoResult lottoResult, Money money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            printRankValueResult(lottoResult, rank);
        }
        double winMoney = lottoResult.calculateWinMoney();
        System.out.printf("총 수익률은 %.1f입니다.", money.calculateYeild(winMoney));
    }

    private void printRankValueResult(LottoResult lottoResult, Rank rank) {
        if (!rank.equals(Rank.LAST)) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.winCount(), rank.winMoney(), lottoResult.getRankCount(rank));
        }
    }

}
