package lotto.view;

public class ResultView {
    private static final String PURCHASE_NUMBER_MESSAGE = "개를 구입했습니다.";
    private static final String STATISTIC_HEADER_MESSAGE = "당첨 통계\n----------------";
    private static final String STATISTIC_BODY_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String STATISTIC_BONUS_BODY_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String STATISTIC_REVENUE_MESSAGE = "총 수익률은 %f 입니다.";

    public static void printPurchaseNumber(int number) {
        System.out.println(number + PURCHASE_NUMBER_MESSAGE);
    }

    public static void printStatistic(int matchNumber, Boolean isBonusMatchNumber, int revenue, int lottoNumberMatched, float earningRate) {
        System.out.println(STATISTIC_HEADER_MESSAGE);
        if (isBonusMatchNumber) {
            System.out.println(String.format(STATISTIC_BONUS_BODY_MESSAGE, matchNumber, revenue, lottoNumberMatched));
        } else {
            System.out.println(String.format(STATISTIC_BODY_MESSAGE, matchNumber, revenue, lottoNumberMatched));
        }
        System.out.println(String.format(STATISTIC_REVENUE_MESSAGE, earningRate));
    }
}
