package step2.view;

import java.util.List;

public class ResultView {
    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchasePrice() {
        printMessage("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int purchaseCount) {
        printMessage(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        printMessage(lottoNumbers.toString());
    }

    public static void printWinNumber() {
        printMessage("");
        printMessage("지난 주 당첨 번호를 입력해 주세요.");
    }
}
