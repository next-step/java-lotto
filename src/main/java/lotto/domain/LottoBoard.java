package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Map;
import java.util.TreeMap;

public class LottoBoard {

    private static final int LOTTO_PURCHASE_AMOUNT_UNIT = 1_000;
    private static final int TOTAL_INIT = 0;
    private static final int COUNT_INIT = 0;
    private Map<Rank, Integer> board = new TreeMap<>();
    private double winningRatio;

    public LottoBoard() {
        for (Rank lottoBoardMatcher : Rank.values()) {
            board.put(lottoBoardMatcher, COUNT_INIT);
        }
    }

    public Map<Rank, Integer> getBoard() {
        return board;
    }

    public double getWinningRatio() {
        return winningRatio;
    }

    public void calculate(Rank lottoMatcher) {
        int count = board.get(lottoMatcher);
        board.put(lottoMatcher, ++count);

        calculateWinningRatio();
    }

    private void calculateWinningRatio() {
        int total = TOTAL_INIT;
        long count = 0l;
        for (Rank lottoBoardMatcher : board.keySet()) {
            total += lottoBoardMatcher.getWinningBonus() * board.get(lottoBoardMatcher);
            count += board.get(lottoBoardMatcher);
        }
        this.winningRatio = (double) total / (count * LOTTO_PURCHASE_AMOUNT_UNIT);
    }
}
