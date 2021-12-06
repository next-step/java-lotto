package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.Map;

public class ResultView {

    private static final String STATISTIC = "\n당첨 통계\n---------";
    private static final String MATCH_FORMAT = "%d개 일치 (%s원)- %d개";
    private static final String RESULT_FORMAT = "총 수익률은 %.2f 입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final Result result;

    public ResultView(Lottos lottos, Lotto answer) {
        this.result = new Result(lottos, answer);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult() {
        Map<Rank, Integer> resultMap = this.result.getResultInfo();
        System.out.println(STATISTIC);

        for (Rank rank : Rank.values()) {
            printRank(resultMap, rank);
        }

        System.out.print(String.format(RESULT_FORMAT, this.result.getRateOfReturn()));
        if (this.result.getRateOfReturn() < 1) {
            System.out.println(LOSS_MESSAGE);
        }
    }

    private void printRank(Map<Rank, Integer> resultMap, Rank rank) {
        if (!rank.equals(Rank.MISS)) {
            System.out.println(String.format(MATCH_FORMAT, rank.getCount(), rank.getAmount(), resultMap.get(rank)));
        }
    }


}
