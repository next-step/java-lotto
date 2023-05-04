package lotto.step3.view;

import lotto.step3.domain.Lottos;
import lotto.step3.domain.Result;
import lotto.step3.domain.TotalReturn;
import lotto.step3.enums.MatchNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String TEXT_WIN_STAT = "당첨 통계";
    public static final String TEXT_LINE = "---------";
    public static final String[] TEXT_RESULT = {"총 수익률은 ", "입니다.", "(기준이 1이기 때문에 결과적으로 손해라는 의미임)", "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"};
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(l -> System.out.println(l.getLotto()));
    }

    private static List<String> getStatResult(Result statMap) {
        return Arrays.stream(MatchNumber.values())
                .map(m -> m.getMatchText() + statMap.getStat().getOrDefault(m, 0) + "개")
                .collect(Collectors.toList());
    }

    public static void printWinnerStat(Result statMap, TotalReturn result) {
        System.out.println(TEXT_WIN_STAT);
        System.out.println(TEXT_LINE);
        getStatResult(statMap).forEach(e -> stringBuilder.append(e).append("\n"));
        stringBuilder.append(TEXT_RESULT[0]).append(result.getTotalReturn()).append(TEXT_RESULT[1]);
        if (result.getTotalReturn() < 1) {
            stringBuilder.append(TEXT_RESULT[2]);
        }
        if (result.getTotalReturn() >= 1) {
            stringBuilder.append(TEXT_RESULT[3]);
        }
        System.out.println(stringBuilder);
    }
}
