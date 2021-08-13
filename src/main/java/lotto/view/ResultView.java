package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Winner;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ResultView {

    private static final ResultView RESULT_VIEW = null;

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

    public void printWinners(Map<Winner, Integer> winnersInfo) {
        out.println("\n당첨 통계");
        out.println("----------");
        winnersInfo.keySet().stream()
                .map(winner -> winner.getMatchCount() + "개 일치 (" + winner.getCash() + "원)- " + winnersInfo.get(winner) + "개")
                .forEach(out::println);
    }

    public void printTotalRevenue(int buyCash, double raffleCash) {
        out.println("총 수익률은 " + String.format("%.2f", raffleCash / (buyCash * 1000)));
    }

}
