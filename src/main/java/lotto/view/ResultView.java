package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    private static final String ANSWER_COUNT_LOTTO_MESSAGE = "개 를 구입 했습니다.";
    private static final String RESULT_OF_LOTTO_GAME_MESSAGE = "당첨 통계\n---------";
    private static final String WINNING_LOTTO_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개\n";
    private static final String RESULT_LOTTO_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";

    private ResultView() {
    }

    public static void printPurchaseLottoCount(int count) {
        System.out.println(count + ANSWER_COUNT_LOTTO_MESSAGE);
    }

    public static void printLottos(List<String> toStringByLottos) {
        for (String str : toStringByLottos) {
            System.out.println(str);
        }
        System.out.println();
    }

    public static void printResultLottoGame(LottoResult lottoResult) {
        System.out.println(RESULT_OF_LOTTO_GAME_MESSAGE);
        System.out.println(printLottoResult(lottoResult));
    }

    private static String printLottoResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Rank rank : lottoResult.getMatchRanks()) {
            stringBuilder.append(String.format(WINNING_LOTTO_RESULT_MESSAGE, rank.getCountOfMath(),
                    rank.getWinningPrize(), lottoResult.countOfMathRanks(rank)));
        }
        return stringBuilder.toString();
    }

    public static void printRateOfLottoGame(double rate) {
        System.out.println(String.format(RESULT_LOTTO_RATE_MESSAGE, rate));
    }
}
