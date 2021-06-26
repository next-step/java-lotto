package lotto.ui.output.report;

import lotto.core.round.Rank;
import lotto.ui.output.result.GameResult;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.ui.output.GameOutput.NEW_LINE;

public class NextStepProblemGameGameReport implements GameReport {
    private static final double PROFIT_STANDARD = 1;

    @Override
    public String format(GameResult gameResult) {
        StringBuilder builder = new StringBuilder(NEW_LINE);

        builder.append("당첨 통계").append(NEW_LINE);
        builder.append("---------").append(NEW_LINE);
        builder.append(statisticsToString(x -> rankFormat(x, gameResult), ignoreThirdWinners())).append(NEW_LINE);
        builder.append(yieldsToString(gameResult.yields())).append(NEW_LINE);
        
        return builder.toString();
    }

    private String statisticsToString(Function<Rank, String> function, Rank ...ranks) {
        return Arrays.stream(ranks)
                .map(rank -> function.apply(rank))
                .collect(Collectors.joining(NEW_LINE));
    }

    private Rank[] ignoreThirdWinners() {
        return Rank.winningValues().stream()
                .filter(x -> x != Rank.THIRD)
                .toArray(Rank[]::new);
    }

    private String rankFormat(Rank rank, GameResult gameResult) {
        int size = gameResult.totalCount(rank);
        String bonusMessage = bonusMessage(rank);

        return String.format("%d개 일치%s(%d원)- %d개", rank.countOfMatch(), bonusMessage, rank.winningMoney(), size);
    }

    private String bonusMessage(Rank rank) {
        if (rank.isDuplicateMatch()) {
            return ", 보너스 볼 일치";
        }

        return " ";
    }

    private String yieldsToString(double yields) {
        String damageMessage = (yields < PROFIT_STANDARD) ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";

        return String.format("총 수익률은 %.2f 입니다.%s", yields, damageMessage);
    }
}
