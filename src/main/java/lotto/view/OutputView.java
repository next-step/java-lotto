package lotto.view;

import lotto.Lottery;

import java.util.List;

public class OutputView {

    public static void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCompletedMessage(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLotteries(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public static void printWinningNumberInputMessage() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printLotteryResult() {
        System.out.printf("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- %d개\n" +
                "4개 일치 (50000원)- %d개\n" +
                "5개 일치 (1500000원)- %d개\n" +
                "6개 일치 (2000000000원)- %d개%n", 1, 2, 3, 4);
    }

    public static void printRateOfReturn(double ratio) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", ratio);
    }
}
