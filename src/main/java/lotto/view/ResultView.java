package lotto.view;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class ResultView {
    public static void printLottos(Lottos lottos){
        System.out.println(String.format("\n%d개를 구매했습니다.", lottos.count()));
        System.out.println(lottos);
    }

    public static void printResults(LottoResult lottoResult, LottoPurchaseAmount amount) {
        System.out.println("\n당첨 통계\n---------");
        printMatchingCounts(lottoResult);
        printTotalProfitRate(lottoResult, amount);
    }
    private static void printMatchingCounts(LottoResult lottoResult) {
        lottoResult.getRanks().stream()
                .forEach(rank -> printMatchingCount(rank, lottoResult.getRankCount(rank)));
    }

    private static void printMatchingCount(Rank rank, Integer rankCount) {
        System.out.println(String.format("%d개 일치 (%d원)- %d개", rank.getMatchingCount(), rank.getPrize(), rankCount));
    }

    private static void printTotalProfitRate(LottoResult lottoResult, LottoPurchaseAmount amount) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculateProfitRate(amount)));
    }



}