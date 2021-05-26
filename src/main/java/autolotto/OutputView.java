package autolotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private final static String THREE_MATCH_WORDING = "3개 일치 (5000원)- %s개";
    private final static String FOUR_MATCH_WORDING = "4개 일치 (50000원)- %s개";
    private final static String FIVE_MATCH_WORDING = "5개 일치 (1500000원)- %s개";
    private final static String SIX_MATCH_WORDING = "6개 일치 (2000000000원)- %s개";
    private final static String TOTAL_MATCH_WORDING_LOSS = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private final static String TOTAL_MATCH_WORDING_PROFIT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)";

    private static final String LOTTO_WIN_RESULT_WORDING = "당첨 통계\n---------";
    private static final String LOTTO_BUY_WORDING = "%s개를 구매했습니다.";

    public static void printBuyingCount(int num) {
        System.out.println(String.format(LOTTO_BUY_WORDING, num));
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lottoNum = lottoList.get(i).lottoNum();
            Collections.sort(lottoNum);
            System.out.println(lottoNum);
        }
    }

    public static void printWinResult(LottoStatistics lottoStatistics) {
        System.out.println(LOTTO_WIN_RESULT_WORDING);
        String output = makeWinWords(lottoStatistics);
        System.out.println(output);
    }

    private static String makeWinWords(LottoStatistics lottoStatistics) {
        String output = String.format(THREE_MATCH_WORDING, lottoStatistics.threeMatch()) + "\n";
        output += String.format(FOUR_MATCH_WORDING, lottoStatistics.fourMatch()) + "\n";
        output += String.format(FIVE_MATCH_WORDING, lottoStatistics.fiveMatch()) + "\n";
        output += String.format(SIX_MATCH_WORDING, lottoStatistics.sixMatch()) + "\n";
        double totalProfitRatio = lottoStatistics.calculateTotalProfit();
        if (totalProfitRatio >= 1) {
            output += String.format(TOTAL_MATCH_WORDING_PROFIT, totalProfitRatio);
            return output;
        }
        output += String.format(TOTAL_MATCH_WORDING_LOSS, totalProfitRatio);
        return output;
    }

}
