package view;

import domain.*;
import util.CalculatorUtil;

import java.util.Map;

public class ResultView {
    public static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    public static final String PRIZE_MESSAGE = "%d개 일치 (%d원) - %d";
    public static final String WINNING_RATE_MESSAGE = "총 수익률은 %.2f입니다.";
    public static final String RESULT_VIEW_MESSAGE = "당첨 통계\n---------";

    public static void viewBuyAmount(int buyAmount) {
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }

    public static void viewIssuedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getValue()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void viewPrize(LottoResults prizes) {
        System.out.println(RESULT_VIEW_MESSAGE);

        for (LottoResult value : prizes.getPrizes()) {
            System.out.println(String.format(PRIZE_MESSAGE, value.getPrizeHitNumber(), value.getPrizeMoney(), value.getWinningNumber()));
        }
    }

    public static void viewWinningRate(int buyPrice, LottoResults prizes) {
        System.out.println(String.format(WINNING_RATE_MESSAGE, CalculatorUtil.divideFloatNumber(prizes.getTotalPrizeMoney(), buyPrice)));
    }
}
