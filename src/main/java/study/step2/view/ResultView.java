package study.step2.view;

import java.util.Map;

public class ResultView {
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String EXCEPTION_INFORMATION_MESSAGE = "로또 구입 금액을 올바르게 입력해주세요.";
    private static final String RESULT_INFORMATION_MESSAGE = "개를 구매했습니다.";
    private static final String NUMBER_REGULAR_EXPRESSION = "^([1-9]\\d*)$";
    private static final int THOUSANDS_JUDGMENT = 10;

    private ResultView() {
    }

    public static int issueLottos(String price) {
        if (isInvalid(price)) {
            throw new IllegalArgumentException(EXCEPTION_INFORMATION_MESSAGE);
        }
        int result = Integer.parseInt(price)/ONE_LOTTO_PRICE;
        System.out.println(result + RESULT_INFORMATION_MESSAGE);
        return result;
    }

    private static boolean isInvalid(String price) {
        if (!price.matches(NUMBER_REGULAR_EXPRESSION)) {
            return true;
        }
        if (Integer.parseInt(price) % THOUSANDS_JUDGMENT != 0) {
            return true;
        }
        return false;
    }

    public static void printAnalysisResult(String lottoPurchasePrice, Map<String, Long> analyzedLotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개", analyzedLotto.get("three"));
        System.out.println();
        System.out.printf("4개 일치 (50000원)- %d개", analyzedLotto.get("four"));
        System.out.println();
        System.out.printf("5개 일치 (1500000원)- %d개", analyzedLotto.get("five"));
        System.out.println();
        System.out.printf("6개 일치 (2000000000원)- %d개", analyzedLotto.get("six"));
        System.out.println();
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", (double) analyzedLotto.get("sum")/Integer.parseInt(lottoPurchasePrice));
    }
}
