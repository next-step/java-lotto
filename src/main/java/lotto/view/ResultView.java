package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.domain.Statistics;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void showStatistic(Statistics statistics) {
        System.out.println(createResult(statistics));
    }

    private static String createResult(Statistics statistics) {
        String result = "";
        result += createForm(statistics, Statistic.THREE) + "\n";
        result += createForm(statistics, Statistic.FOUR) + "\n";
        result += createForm(statistics, Statistic.FIVE) + "\n";
        result += createForm(statistics, Statistic.SIX) + "\n";

        result += createFormSum(statistics) + "\n";

        return result;
    }

    private static String createForm(Statistics statistics, Statistic kind) {
        int count = (int) statistics.getStatistics().stream().filter(statistic -> kind == statistic).count();
        return kind.getMatcher() + "개 일치 (" + kind.getPrice() + ")-" + count;

    }

    private static String createFormSum(Statistics statistics) {
        float rate = statistics.getRateOfReturn();
        return "총 수익률은 " + String.format("%.2f", rate) + "입니다.(기준이 1이기 때문에 결과적으로 " + checkLoss(rate) + "라는 의미임)";
    }

    private static String checkLoss(float rate) {
        if (rate > 1) {
            return "이득이";
        }
        return "손해";
    }

    public static void showGeneratedLottos(List<Lotto> lottos) {
        System.out.println(lottos.stream().map(ResultView::createLottoForm).collect(Collectors.joining()));
    }

    private static String createLottoForm(Lotto lotto) {
        String result = String.join(", ", lotto.getLotto().stream().map(integer -> String.valueOf(integer)).collect(Collectors.toList()));
        result = "[" + result + "]\n";
        return result;
    }
}
