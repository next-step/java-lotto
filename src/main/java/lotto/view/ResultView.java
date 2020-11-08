package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.WinningReward;
import lotto.domain.winning.WinningStatistics;

import java.io.PrintWriter;
import java.util.stream.Collectors;

public class ResultView {
    private static final String FORMAT_FOR_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String FORMAT_FOR_LOTTO_NUMBERS = "[%s]";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String HEADER_WINNING = "당첨 통계";
    private static final String LINE_SEPARATION = "---------";
    private static final String FORMAT_FOR_WINNING = "%d개 일치 (%d원)- %d개";
    private static final String FORMAT_FOR_WINNING_WITH_BONUS = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String FORMAT_FOR_YIELD = "총 수익률은 %.2f입니다.";
    private static final String PHRASE_FOR_FACT_HITTING = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void showLottos(Lottos lottos, int manualLottoCount) {
        output.println(String.format(FORMAT_FOR_LOTTO_COUNT, manualLottoCount, lottos.getCount() - manualLottoCount));
        lottos.getLottoNumbers().stream()
                .map(this::convertLottoNumbersToString)
                .forEach(output::println);
        output.println();
    }

    private String convertLottoNumbersToString(Lotto lotto) {
        return String.format(FORMAT_FOR_LOTTO_NUMBERS, lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER)));
    }

    public void showResult(WinningStatistics winningStatistics, double yield) {
        output.println();
        output.println(HEADER_WINNING);
        output.println(LINE_SEPARATION);
        WinningReward.valuesStreamWithoutZero()
                .map(winningReward -> convertRewardAndStatisticsToString(winningReward, winningStatistics))
                .forEach(output::println);
        output.println(convertYieldToString(yield));
    }

    private String convertRewardAndStatisticsToString(WinningReward winningReward, WinningStatistics winningStatistics) {
        if (winningReward.matchBonusNumber()) {
            return formatWinning(winningReward, winningStatistics, FORMAT_FOR_WINNING_WITH_BONUS);
        }
        return formatWinning(winningReward, winningStatistics, FORMAT_FOR_WINNING);
    }

    private String formatWinning(WinningReward winningReward, WinningStatistics winningStatistics, String formatForWinning) {
        return String.format(formatForWinning,
                winningReward.getCount(),
                winningReward.getWinningPrice(),
                winningStatistics.getWinningLottoCount(winningReward));
    }

    private String convertYieldToString(double yield) {
        StringBuilder builder = new StringBuilder(FORMAT_FOR_YIELD);
        if (yield < 1) {
            builder.append(PHRASE_FOR_FACT_HITTING);
        }
        return String.format(builder.toString(), yield);
    }

    public void showErrorMessage(String message) {
        output.println(message);
        output.println("처음부터 시작해주세요.");
        output.println(LINE_SEPARATION);
        output.println("");
        output.println("");
    }
}
