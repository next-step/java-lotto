package view;

import domain.*;
import util.CalculatorUtil;

public class ResultView {
    public static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    public static final String PRIZE_MESSAGE = "%d개 일치 (%d원) - %d\n";
    public static final String SECOND_PRIZE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d\n";
    public static final String WINNING_RATE_MESSAGE = "총 수익률은 %.2f입니다.";
    public static final String RESULT_VIEW_MESSAGE = "당첨 통계\n---------";

    private ResultView() {
    }

    public static void viewBuyAmount(int buyAmount) {
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }

    public static void viewIssuedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void viewPrize(LottoResults prizes) {
        System.out.println(RESULT_VIEW_MESSAGE);
        System.out.println(viewLottoPrizes(prizes));
    }

    public static void viewWinningRate(int buyPrice, LottoResults prizes) {
        System.out.println(String.format(WINNING_RATE_MESSAGE, CalculatorUtil.divide(prizes.getTotalPrizeMoney(), buyPrice)));
    }

    private static String viewLottoPrizes(LottoResults prizes) {
        StringBuilder sb = new StringBuilder();

        for (LottoResult value : prizes.getLottoResults()) {
            sb.append(String.format(
                    value.getRank().equals(Rank.SECOND) ? SECOND_PRIZE_MESSAGE : PRIZE_MESSAGE,
                    value.getPrizeHitNumber(),
                    value.getPrizeMoney(),
                    value.getWinningCount()));
        }

        return sb.toString();
    }
}
