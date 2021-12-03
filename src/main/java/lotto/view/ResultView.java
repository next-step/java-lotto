package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.dto.StatisticResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class ResultView {

    private static final String WON_STATISTICS = "당첨 통계";
    private static final String LINE = "--------";
    private static final String PRINT_MANUAL_AUTO_COUNT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";

    public void printPurchaseLottos(List<Lotto> manual, List<Lotto> auto) {
        List<Lotto> lotto = new ArrayList<>();

    public void printPurchaseLottos(List<Lotto> lotto) {
        if (lotto == null || lotto.isEmpty()) {
            return;
        }

        for (Lotto l : lotto) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(lottoNumberWithJoinedByComma(l));
            sb.append("]");
            System.out.println(sb);
        }
    }

    public void printResultStatics(Statistics statistics) {
        System.out.println(WON_STATISTICS);
        System.out.println(LINE);
        System.out.println(statisticResult(statistics.getStatisticResult()));
    }

    private String lottoNumberWithJoinedByComma(Lotto lotto) {
        return lotto.getNumbers()
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(","));
    }

    private String statisticResult(StatisticResult result) {
        Map<Rank, Long> map = result.getRankIntegerMap();

        List<Rank> ranks = Rank.wonRanks;

        StringBuilder sb = new StringBuilder();
        for (Rank r : ranks) {
            sb.append(r.getMatch());
            sb.append("개 일치 ");
            appendIfSecond(r, sb);
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

    private void appendIfSecond(Rank rank, StringBuilder sb) {
        if (rank.equals(Rank.SECOND)) {
            sb.append(",");
            sb.append(" 보너스 볼 일치");
        }
    }
}
