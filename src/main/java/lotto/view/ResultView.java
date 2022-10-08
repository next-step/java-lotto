package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Map;
import java.util.Objects;

public class ResultView {

    public static final String MSG_PURCHASE_NUMBER = "개를 구매했습니다.";
    public static final String MSG_WINNING_RESULT = "당첨 통계";
    public static final String DOTTED_LINE_MARK = "---------";
    public static final int MIN_WINNING_COUNT = 3;
    public static final int MAX_WINNING_COUNT = 6;
    public static final String LOTTO_UNIT = "개";
    public static final String MSG_SAME = " 일치";
    public static final String LINE = "- ";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String MONEY_UNIT = "원";
    public static final String MSG_PROFIT_RATE_IS = "총 수익률은 ";
    public static final String MSG_END_SENTENCE = "입니다.";

    private static int[] winningPrice = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    public static void printPurchaseNumber(int n) {
        System.out.println(n + MSG_PURCHASE_NUMBER);

    }

    public static void printLottoNumbers(Lottos lottos) {
        for (String s : lottos.toStringList()) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void printWinningResult(Map<Integer, Integer> result) {
        System.out.println(MSG_WINNING_RESULT);
        System.out.println(DOTTED_LINE_MARK);
        for (int i = MIN_WINNING_COUNT; i <= MAX_WINNING_COUNT; i++) {
            int count = Objects.isNull(result.get(i)) ? 0 : result.get(i);
            System.out.println(i + LOTTO_UNIT + MSG_SAME + LEFT_BRACKET + winningPrice[i] + MONEY_UNIT + RIGHT_BRACKET + LINE + count + LOTTO_UNIT);
        }
    }

    public static void printProfitRate(Lottos lottos) {
        System.out.println(MSG_PROFIT_RATE_IS + lottos.getProfitRate() + MSG_END_SENTENCE);
    }
}
