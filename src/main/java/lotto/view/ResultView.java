package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ResultView {

    private static final ResultView RESULT_VIEW = null;
    private static final String WINNING_STATS = "\n당첨 통계\n----------";
    private static final String PRINT_WINNER_FORM = "%s개 일치 (%s원)- %s개%n";
    private static final String PRINT_PROFIT_RATE_FORM = "총 수익률은 %s입니다.%n";
    private static final String EXCEPTION_MESSAGE = "구매 금액이 올바른 값이 아닙니다.(현재 금액에서 구매가능한 %s개만 구매합니다.)%n)";
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    public static synchronized ResultView getInstance() {
        if (RESULT_VIEW == null) {
            return new ResultView();
        }
        return RESULT_VIEW;
    }

    private ResultView() {

    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(out::println);
    }

    public void printWinners(Map<Rank, Integer> winnersInfo) {
        out.println(WINNING_STATS);
        winnersInfo.remove(Rank.NONE);
        winnersInfo.keySet().stream()
                .forEach(winner -> {
                    out.printf(PRINT_WINNER_FORM, winner.getMatchCount(), winner.getCash(), winnersInfo.get(winner));
                });
    }

    public void printProfitRate(int lottoCount, Map<Rank, Integer> winningInfo) {
        int buyCash = lottoCount * PURCHASE_AMOUNT_UNIT;
        double raffleCash = winningInfo.keySet().stream()
                .mapToDouble(winner -> winner.getCash() * winningInfo.get(winner))
                .sum();
        out.printf(PRINT_PROFIT_RATE_FORM, String.format("%.2f", raffleCash / buyCash));
    }

    public void printReInputMessage(int purchaseAmount) {
        out.printf(EXCEPTION_MESSAGE, purchaseAmount);
    }

}
