package auto_lotto.view;


import auto_lotto.domain.LottoTicket;
import auto_lotto.domain.WinningInfo;

import java.util.List;
import java.util.Map;

public class ResultView {


    public void purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printReceive(int size) {
        System.out.println(size +"개를 구매했습니다.");
    }

    public void printWinningInfos(Map<WinningInfo, Long> winningInfos, long totalPurchase) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        printStatistics(winningInfos, totalPurchase);
    }
    public void printLotto(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    private static void printStatistics(Map<WinningInfo, Long> statistics, long purchaseAmount) {
        long totalEarnings = 0;

        for (WinningInfo winningInfo : WinningInfo.values()) {
            if (winningInfo != WinningInfo.NONE_MATCHES) {
                long count = statistics.getOrDefault(winningInfo, 0L);
                System.out.println(winningInfo.getMatches() + "개 일치 (" + winningInfo.getReward() + "원)- " + count + "개");
                totalEarnings += winningInfo.getReward() * count;
            }
        }

        double profitRatio = (double) totalEarnings / purchaseAmount;
        System.out.println("총 수익률은 " + String.format("%.2f", profitRatio) + "입니다." + (profitRatio < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : ""));
    }
}
