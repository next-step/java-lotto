package step2.view;

import java.util.List;

public class ResultView {
    private static final String purchasePrice = "구입금액을 입력해 주세요.";
    private static final String winNumber = "지난 주 당첨 번호를 입력해 주세요.";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchasePrice() {
        printMessage(purchasePrice);
    }

    public static void printPurchaseCount(int purchaseCount) {
        printMessage(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        printMessage(lottoNumbers.toString());
    }

    public static void printWinNumber() {
        printMessage("");
        printMessage(winNumber);
    }

    public static void printWinCounts(int[][] winCounts) {
        printMessage("");
        printMessage("당첨 통계");
        printMessage("--------");
        for (int i = 0; i < winCounts.length; i++) {
            printMessage((i + 3) + "개 일치 (" + winCounts[i][1] + ")원- " + winCounts[i][0] + "개");
        }
    }

    public static void printTotalRevenue(double totalRevenue) {
        printMessage("총 수익률은 " + totalRevenue + "입니다.");
    }
}
