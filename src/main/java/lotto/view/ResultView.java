package lotto.view;

import lotto.domain.WinningReward;
import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lottos;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void showLottos(Lottos lottos) {
        output.println(String.format("%d개를 구매했습니다.", lottos.getCount()));
        lottos.getLottoNumbers().stream()
                .map(this::convertLottoNumbersToString)
                .forEach(output::println);
        output.println();
    }

    private String convertLottoNumbersToString(List<Integer> numbers) {
        return String.format("[%s]", numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    public void showResult(WinningStatistics winningStatistics, double yield) {
        output.println();
        output.println("당첨 통계");
        output.println("---------");
        Arrays.stream(WinningReward.values())
                .map(winningReward -> convertRewardAndStatisticsToString(winningReward, winningStatistics))
                .forEach(output::println);
        output.println(convertYieldToString(yield));
    }

    private String convertYieldToString(double yield) {
        if (yield < 1) {
            return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", yield);
        }
        return String.format("총 수익률은 %.2f입니다.", yield);
    }

    private String convertRewardAndStatisticsToString(WinningReward winningReward, WinningStatistics winningStatistics) {
        return String.format("%d개 일치 (%d원)- %d개",
                winningReward.getCount(),
                winningReward.getWinningPrice(),
                winningStatistics.getWinningLottoCount(winningReward.getCount()));
    }
}
