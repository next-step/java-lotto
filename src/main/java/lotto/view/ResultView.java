package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchaseMachine;
import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.dto.StatisticsResult;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class ResultView {

    private static final String WON_STATISTICS = "당첨 통계";
    private static final String LINE = "--------";

    public void printPurchaseLottos(PurchaseMachine purchaseMachine) {
        List<Lotto> lottoList = purchaseMachine.getLottoList();

        for (Lotto l : lottoList) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(lottoNumberWithJoinedByComma(l));
            sb.append("]");
            System.out.println(sb);
        }
    }

    public void printResultStatics(PurchaseMachine purchaseMachine) {
        Statistics statistics = purchaseMachine.getStatistics();
        System.out.println(WON_STATISTICS);
        System.out.println(LINE);
        System.out.println(statisticResult(statistics.getMatchResult()));
    }

    private String lottoNumberWithJoinedByComma(Lotto lotto) {
        return lotto.getNumbers()
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(","));
    }

    private String statisticResult(StatisticsResult result) {
        Map<Rank, Integer> map = result.getRankIntegerMap();

        Set<Rank> ranks = map.keySet();

        StringBuilder sb = new StringBuilder();
        for (Rank r : ranks) {
            sb.append(r.getMatch());
            sb.append("개 일치 ");
            sb.append("(");
            sb.append(r.getMoney());
            sb.append(")- ");
            sb.append(map.get(r));
            sb.append("개");
            sb.append("\n");
        }

        sb.append("총 수익률은 ");
        sb.append(result.getProfit());
        sb.append("입니다");
        return sb.toString();
    }
}
