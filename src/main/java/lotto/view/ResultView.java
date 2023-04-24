package lotto.view;

import java.util.List;

public class ResultView {

    public static void printPurchasePriceInputCommand() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottoNum(List<Integer> lottoNum) {
        System.out.println(lottoNum);
    }

    public static void printWinningNumInputCommand() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

}
