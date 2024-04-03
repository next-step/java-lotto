package lotto.view;


import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningInfo;

import java.util.List;

public class ResultView {

    public void printWinningInfos(LottoResult lottoResult, long totalPurchase) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        printStatistics(lottoResult, totalPurchase);
    }

    public void printLotto(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.numbers());
        }
    }

    private static void printStatistics(LottoResult lottoResult, long totalPurchase) {
        long totalEarnings = 0;

        for (WinningInfo winningInfo : WinningInfo.values()) {
            Long count = lottoResult.countMatch(winningInfo);
            print(winningInfo, count);

            totalEarnings += winningInfo.getReward() * count;
        }

        double profitRatio = lottoResult.calculateProfitRatio(totalEarnings, totalPurchase);
        print(profitRatio);
    }

    private static void print(WinningInfo winningInfo, Long count) {
        System.out.println(winningInfo.getMatches() + "개 일치 (" + winningInfo.getReward() + "원)- " + count + "개");
    }

    private static void print(double profitRatio) {
        System.out.println("총 수익률은 " + String.format("%.2f", profitRatio) + "입니다." + (profitRatio < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""));
    }
}
