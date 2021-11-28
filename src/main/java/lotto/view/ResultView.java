package lotto.view;

public class ResultView {
    private static String RESPONSE_LOTTO_COUNT = "%s개를 구매했습니다.\n";
    public static String RESPONSE_INIT_MESSAGE = "당첨 통계";
    public static String RESPONSE_INIT_LINE = "---------";
    public static String RESPONSE_THREE_MATCH_MESSAGE = "3개 일치 (5000원)- %s개\n";
    public static String RESPONSE_FOUR_MATCH_MESSAGE = "4개 일치 (50000원)- %s개\n";
    public static String RESPONSE_FIVE_MATCH_MESSAGE = "5개 일치 (1500000원)- %s개\n";
    public static String RESPONSE_SIX_MATCH_MESSAGE = "6개 일치 (2000000000원)- %s개\n";
    public static String RESPONSE_TOTAL_EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    public static void responseLottoCount(int purchaseLottoCount) {
        System.out.format(RESPONSE_LOTTO_COUNT, purchaseLottoCount);
    }

    public static void responseLottoNumbers() {

    }

    public static void responseWinningStatistics() {

    }
}
