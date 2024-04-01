package lotto.view;


import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningInfo;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningInfos(LottoResult lottoResult, long totalPurchase) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        printStatistics(lottoResult, totalPurchase);
    }

    public void printLotto(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() +"개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.intgerList());
        }
    }

    private static void printStatistics(LottoResult lottoResult, long purchaseAmount) {
        long totalEarnings = 0;

        for (WinningInfo winningInfo : WinningInfo.values()) {
            if (winningInfo != WinningInfo.NONE_MATCHES) {

                Long count = lottoResult.countMatch(winningInfo);

                System.out.println(winningInfo.getMatches() + "개 일치 (" + winningInfo.getReward() + "원)- " + count + "개");
                totalEarnings += winningInfo.getReward() * count;
            }
        }

        double profitRatio = (double) totalEarnings / purchaseAmount;
        System.out.println("총 수익률은 " + String.format("%.2f", profitRatio) + "입니다." + (profitRatio < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""));
    }
}
