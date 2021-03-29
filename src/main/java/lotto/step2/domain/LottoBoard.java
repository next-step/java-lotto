package lotto.step2.domain;

import lotto.step2.domain.enums.LottoMatcher;

import java.util.Map;
import java.util.TreeMap;

public class LottoBoard {

    private static final int LOTTO_PURCHASE_AMOUNT_UNIT = 1_000;
    private static final int TOTAL_INIT = 0;
    private static final int COUNT_INIT = 0;
    private Map<LottoMatcher, Integer> board = new TreeMap<>();
    private double winningRatio;

    public LottoBoard() {
        for (LottoMatcher lottoBoardMatcher : LottoMatcher.values()) {
            board.put(lottoBoardMatcher, COUNT_INIT);
        }
    }

    public Map<LottoMatcher, Integer> getBoard() {
        return board;
    }

    public double getWinningRatio() {
        return winningRatio;
    }

    public void calculate(LottoMatcher lottoMatcher) {
        int count = board.get(lottoMatcher);
        board.put(lottoMatcher, ++count);

        calculateWinningRatio();
    }

    private void calculateWinningRatio() {
        int total = TOTAL_INIT;
        long count = board.values().stream().count();
        for (LottoMatcher lottoBoardMatcher : board.keySet()) {
            total += lottoBoardMatcher.getWinningBonus() * board.get(lottoBoardMatcher);
            count += board.get(lottoBoardMatcher);
        }
        this.winningRatio = (double) total / (count * LOTTO_PURCHASE_AMOUNT_UNIT);
    }
}
