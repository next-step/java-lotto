package step2.view;

import step2.domain.model.WinningAmountByRank;

import java.util.Map;

public class OutputView {
    private OutputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static void outPut(int result) {
        System.out.println(String.format("%d개를 구매하였습니다.", result));
    }

    public static void outPutProfit(double Profit, Map<String, Integer> winningCount) {
        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.FOURTH.getRank(),
                WinningAmountByRank.FOURTH.getAmount(), winningCount.getOrDefault(WinningAmountByRank.FOURTH.getKey(), 0)));

        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.THIRD.getRank(),
                WinningAmountByRank.THIRD.getAmount(), winningCount.getOrDefault(WinningAmountByRank.THIRD.getKey(), 0)));

        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.SECOND.getRank(),
                WinningAmountByRank.SECOND.getAmount(), winningCount.getOrDefault(WinningAmountByRank.SECOND.getKey(), 0)));

        System.out.println(String.format("%d개 일치 (%d원)- %d개", WinningAmountByRank.FIRST.getRank(),
                WinningAmountByRank.FIRST.getAmount(), winningCount.getOrDefault(WinningAmountByRank.FIRST.getKey(), 0)));
        System.out.println(String.format("수익률 %f.", Profit));
    }
}
