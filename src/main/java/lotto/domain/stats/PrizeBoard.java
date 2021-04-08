package lotto.domain.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.prize.Prize;

public class PrizeBoard {
    private final Map<Prize, Long> board;

    public PrizeBoard() {
        board = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(prize -> board.put(prize, 0L));
    }

    public void record(Prize prize) {
        board.put(prize, board.get(prize) + 1L);
    }

    public long getWinnerCountByPrize(Prize prize) {
        return board.get(prize);
    }

    public long getWinnerCountWithNothingPrizeTotal() {
        long winnerCountTotal = 0L;
        for (Prize prize : Prize.values()) {
            winnerCountTotal += board.get(prize);
        }
        return winnerCountTotal;
    }

    public long getWinnersPrizeAmountByPrize(Prize prize) {
        return prize.getPrizeAmount() * board.get(prize);
    }

    public long getWinnersPrizeAmountTotal() {
        long prizeAmountTotal = 0L;
        for (Prize prize : Prize.values()) {
            prizeAmountTotal += getWinnersPrizeAmountByPrize(prize);
        }
        return prizeAmountTotal;
    }

    public List<Score> getScoreResult() {
        List<Score> scoreResult = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            scoreResult.add(new Score(
               prize.getScore(),
               prize.getMatchingBallCount(),
               prize.getPrizeAmount(),
               getWinnerCountByPrize(prize)
            ));
        }
        return scoreResult;
    }
}
