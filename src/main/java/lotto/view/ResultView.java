package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;

import static java.math.RoundingMode.FLOOR;

public class ResultView {
    private static final String ANSWER_COUNT_LOTTO_MESSAGE = "\n수동으로 %s개, 자동으로 %s개를 구매 했습니다.";
    private static final String RESULT_OF_LOTTO_GAME_MESSAGE = "\n당첨 통계\n---------";
    private static final String RANK_COUNT_OF_MATCH_MESSAGE = "%s개 일치";
    private static final String BONUS_BALL_COUNT_MESSAGE = ", 보너스 볼 일치";
    private static final String WINNING_LOTTO_COUNT_OF_MATCH_MESSAGE = "(%s원)- %s개\n";
    private static final String RESULT_LOTTO_RATE_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";
    private static final String EMPTY_STRING = " ";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

    private ResultView() {
    }

    public static void printPurchaseLottoCount(int autoCount, int manualCount) {
        System.out.println(String.format(ANSWER_COUNT_LOTTO_MESSAGE, autoCount, manualCount));
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
        double rateOfLottoGame = lottoResult.rateOfTotalPrize();
        printRateOfLottoGame(rateOfLottoGame);
    }

    private static String printLottoResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Rank rank : Rank.ranks()) {
            stringBuilder.append(String.format(RANK_COUNT_OF_MATCH_MESSAGE, rank.getCountOfMatch()));
            stringBuilder.append(rank.isMatchBonusBall() ? BONUS_BALL_COUNT_MESSAGE : EMPTY_STRING);
            stringBuilder.append(String.format(WINNING_LOTTO_COUNT_OF_MATCH_MESSAGE,
                    rank.getWinningPrize(), lottoResult.countOfMathRanks(rank)));
        }
        return stringBuilder.toString();
    }

    public static void printRateOfLottoGame(double rate) {
        DECIMAL_FORMAT.setRoundingMode(FLOOR);
        System.out.println(String.format(RESULT_LOTTO_RATE_MESSAGE, DECIMAL_FORMAT.format(rate)));
    }
}
