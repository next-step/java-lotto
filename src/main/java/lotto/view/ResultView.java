package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers();
        System.out.println(numbers.toString());
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printMatchStaticsInfo(List<Integer> staticsList) {
        printMatchStaticsDescription();

    }

    private static void printMatchStaticsDescription() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profitRate);
    }
}
