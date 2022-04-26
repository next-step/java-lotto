package me.devyonghee.lotto.view;

import me.devyonghee.lotto.view.dto.LottosResponse;
import me.devyonghee.lotto.view.dto.RankResponse;
import me.devyonghee.lotto.view.dto.ScoreResponse;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class ResultView {

    private static final String NULL_OUTPUT_ERROR_MESSAGE = "output must not be null";
    private static final String PURCHASE_LOTTOS_MESSAGE_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    private static final String RANK_RESULT_MESSAGE_FORMAT = "%d개 일치%s (%d원)- %d개\n";
    private static final String UNMATCHED_BONUS_MESSAGE_FORMAT = "";
    private static final String MATCHED_BONUS_MESSAGE_FORMAT = ", 보너스 볼 일치";
    private static final String PROFIT_RATE_RESULT_MESSAGE_FORMAT = "총 수익률은 %s입니다.";
    private static final String PROFIT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";


    private final PrintStream output;

    private ResultView(PrintStream output) {
        Objects.requireNonNull(output, NULL_OUTPUT_ERROR_MESSAGE);
        this.output = output;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }

    public void print(LottosResponse response) {
        output.printf(PURCHASE_LOTTOS_MESSAGE_FORMAT, response.getManualCount(), response.getAutoCount());
        for (List<Integer> ticket : response.getLottos()) {
            output.println(ticket);
        }
    }

    public void print(ScoreResponse response) {
        printRank(response.getFourthRank());
        printRank(response.getThirdRank());
        printRank(response.getSecondRank());
        printRank(response.getFirstRank());
        BigDecimal profitRatio = response.getProfitRatio();
        output.printf(PROFIT_RATE_RESULT_MESSAGE_FORMAT, profitRatio);
        if (profitRatio.compareTo(BigDecimal.ONE) < 0) {
            output.print(PROFIT_LOSS_MESSAGE);
        }
    }

    private void printRank(RankResponse rank) {
        if (rank.isMatchedBonus()) {
            output.printf(RANK_RESULT_MESSAGE_FORMAT, rank.getMatchCount(), MATCHED_BONUS_MESSAGE_FORMAT, rank.getPrize(), rank.getCount());
            return;
        }
        output.printf(RANK_RESULT_MESSAGE_FORMAT, rank.getMatchCount(), UNMATCHED_BONUS_MESSAGE_FORMAT, rank.getPrize(), rank.getCount());
    }
}
