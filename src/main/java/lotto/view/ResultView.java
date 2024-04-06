package lotto.view;

import lotto.domain.*;

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
        return matcher.getMatcher() + "개 일치" + createBonusMatchForm(matcher) + "(" + matcher.getPrice() + ")-" + statistics.getMatchCount(matcher);
    }

    private static String createBonusMatchForm (Statistic matcher) {
        if (matcher.isBonusRequired()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private static String createRateForm(Statistics statistics) {
        float rate = statistics.getRateOfReturn();
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

    public static void showLottoQuantity(Lottos manualLottos, Lottos autoLottos) {
        System.out.println("수동으로 " + manualLottos.getLottoSize() + "장, 자동으로" + autoLottos.getLottoSize() + "개를 구매했습니다.");
    }
}
