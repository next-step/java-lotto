package lotto.view;

import lotto.Lotto;
import lotto.LottoRank;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {
    static class TEXT {
        public static String BOUGHT_LOTTO_COUNT = "%d 개를 구매했습니다.%n";
        public static String TITLE_WINNING_LOTTO_RESULT = "당첨 통계";
        public static String DASH_BAR = "---------------";
        public static String WINNING_LOTTO_RESULT = "%d 개 일치(%d 원) - %개%n";
        public static String TOTAL_RETURN_VALUE = "총 수익률은 %.2f 입니다.%n";
    }

    public static void printWinningLottoTitle() {
        System.out.println(TEXT.TITLE_WINNING_LOTTO_RESULT);
    }

    public static void printDashBar() {
        System.out.println(TEXT.DASH_BAR);
    }

    public static void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printSameCountWinningNumber(LottoRank lottoRank, int sameCount) {
        System.out.printf(TEXT.WINNING_LOTTO_RESULT,
                lottoRank.getContainCountsSameWinningNumber(),
                lottoRank.getWinningAmount(),
                sameCount);
    }

    public static void printBuyLottoCount(int buyCount) {
        System.out.printf(TEXT.BOUGHT_LOTTO_COUNT, buyCount);
    }

    public static void printReturnValue(BigDecimal winningAmount, BigDecimal buyAmount) {
        System.out.printf(TEXT.TOTAL_RETURN_VALUE, winningAmount.divide(buyAmount));
    }

}
