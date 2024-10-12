package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {

    public static final int LOTTO_PRICE = 1000;

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

    public static void printProfitRate(int profitAmount, int quantity) {
        Double profitRate = (double) profitAmount / (quantity * LOTTO_PRICE);
        System.out.printf("총수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n", profitRate, getResultMessage(profitRate));
    }

    private static String getResultMessage(Double profitRate) {
        if (profitRate.compareTo(1.0) > 0) {
            return "이득이";
        }
        return "손해";
    }
}
