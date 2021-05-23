package lotto.ui;

import lotto.enums.Payout;

public class OutputUI {
    public static void printInputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printNumberOfPurchases(int number) {
        System.out.println(number+"개를 구매했습니다.");
    }
    public static void printInputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }
    public static void printStatistics(int matchNumber, int count) {
        System.out.printf("%d개 일치 (%d원)- %d개",matchNumber, Payout.getPayout(matchNumber), count);
        System.out.println();
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %s 입니다.", String.format("%.2f",rateOfReturn));
    }
}
