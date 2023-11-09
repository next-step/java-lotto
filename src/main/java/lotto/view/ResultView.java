package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.Revenue;
import lotto.domain.WinningResults;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String BUYING_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String LINE = "---------";
    private static final String OPENING_PARENTHESIS = " (";
    private static final String CLOSING_PARENTHESIS = ")- ";
    private static final String QUANTITY = "개";
    private static final String REVENUE_TOTAL = "총 수익률은 ";
    private static final String THAT = "입니다.";
    private static final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String BR = "\n";

    private ResultView() {
    }

    public static void reportBuying(int lottoCount,
                                    List<LottoNumber> lottoNumbers) {
        System.out.println(lottoCount + BUYING_QUANTITY);
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.toString());
        }
        br();
    }

    public static void reportStats(WinningResults winningResults,
                                   int amount) {
        br();
        System.out.println(WINNING_STATS);
        System.out.println(LINE);

        Map<LottoRank, Integer> winningResult = winningResults.getAll();
        for (Map.Entry<LottoRank, Integer> result : winningResult.entrySet()) {
            LottoRank lottoRank = result.getKey();
            if (lottoRank.isNotMatched()) {
                System.out.println(lottoRank.description() + OPENING_PARENTHESIS + lottoRank.prizeToString() + CLOSING_PARENTHESIS + result.getValue() +
                        QUANTITY);
            }
        }

        Revenue revenue = winningResults.revenue(amount);
        System.out.print(REVENUE_TOTAL + revenue.toString() + THAT);
        if (!revenue.isBenefit()) {
            System.out.println(LOSS);
        }

    }

    private static void br() {
        System.out.print(BR);
    }
}
