package lotto.view;

public class LottoOutView {
    private static final String STATISTIC_HEADER = "당첨 통계\n---------";

    public static void showStatistic(StringBuilder result) {
        System.out.println(STATISTIC_HEADER);
        System.out.println(result);
    }

    public static void show(StringBuilder message) {
        System.out.println(message);
    }
}
