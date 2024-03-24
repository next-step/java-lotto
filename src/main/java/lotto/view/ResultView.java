package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Statistic;
import lotto.domain.Statistics;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultView {
    public static void showStatistic(Statistics statistics) {
        System.out.println(createResult(statistics));
    }

    private static String createResult(Statistics statistics) {
        return String.join("\n", getResults(statistics), createRateForm(statistics));
    }

    private static String getResults(Statistics statistics) {
        return Arrays.stream(Statistic.values())
                .map(matcher -> createStatisticForm(statistics, matcher))
                .collect(Collectors.joining("\n", "", "\n"));
    }


    private static String createStatisticForm(Statistics statistics, Statistic matcher) {
        return matcher.getMatcher() + "개 일치 (" + matcher.getPrice() + ")-" + statistics.getMatchCount(matcher);
    }

    private static String createRateForm(Statistics statistics) {
        float rate = statistics.getRateOfReturn(Lotto.LOTTO_PRICE);
        return "총 수익률은 " + String.format("%.2f", rate) + "입니다.(기준이 1이기 때문에 결과적으로 " + checkLoss(rate) + "라는 의미임)";
    }

    private static String checkLoss(float rate) {
        if (rate > 1) {
            return "이득이";
        }
        return "손해";
    }

    public static void showGeneratedLottos(Lottos lottos) {
        System.out.println(
                lottos.getLottos()
                .stream()
                .map(ResultView::createLottoForm)
                .collect(Collectors.joining())
        );
    }

    private static String createLottoForm(Lotto lotto) {
        String result = String.join(
                ", ",
                lotto.getLotto()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getValue()))
                .collect(Collectors.toList()));
        result = "[" + result + "]\n";
        return result;
    }
}
