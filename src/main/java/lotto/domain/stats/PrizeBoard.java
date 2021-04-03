package lotto.domain.stats;

import java.util.Arrays;
import java.util.HashMap;
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
}
