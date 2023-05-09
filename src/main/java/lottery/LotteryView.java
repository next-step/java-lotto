package lottery;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LotteryView {
    static final Integer MIN_WINNING_MATCH_CNT = 3;
    static final Map<PnLType, String> pnLMessage = Map.of(
            PnLType.LOSS, "기준이 1이기 때문에 결과적으로 손해라는 의미임",
            PnLType.EVEN, "기준이 1이기 때문에 결과적으로 본전이라는 의미임",
            PnLType.PROFIT, "기준이 1이기 때문에 결과적으로 이득이라는 의미임"
    );

    public Integer getBuyAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void showBuyResult(List<Lottery> lotteries) {
        System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
        for (var lottery : lotteries) {
            System.out.println(lottery.getNumbers());
        }
    }

    public String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showStatistics(LotteryStatistics statistics) {
        showResultTitle();
        showLotteryCntForMatchingCnt(statistics);
        showPnL(statistics);
    }

    private void showResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void showLotteryCntForMatchingCnt(LotteryStatistics lotteryStatistics) {
        for (var matchCnt = MIN_WINNING_MATCH_CNT; matchCnt <= LotteryRow.ROW_SIZE; matchCnt++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", matchCnt, LotteryStatistics.getRewardForMatchCnt(matchCnt), lotteryStatistics.getLotteryCntForMatchCnt(matchCnt));
        }
    }

    private void showPnL(LotteryStatistics lotteryStatistics) {
        System.out.printf("총 수익률은 %.2f입니다.(%s)", lotteryStatistics.getRor(), pnLMessage.get(lotteryStatistics.getPnLType()));
    }
}
