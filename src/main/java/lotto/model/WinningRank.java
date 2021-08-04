package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WinningRank {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000);

    private static final Map<Integer, WinningRank> ANSWER_COUNT_WINNING_RANK_MAP = new HashMap<>();

    static {
        ANSWER_COUNT_WINNING_RANK_MAP.put(FIRST_PLACE.answerCount, FIRST_PLACE);
        ANSWER_COUNT_WINNING_RANK_MAP.put(SECOND_PLACE.answerCount, SECOND_PLACE);
        ANSWER_COUNT_WINNING_RANK_MAP.put(THIRD_PLACE.answerCount, THIRD_PLACE);
        ANSWER_COUNT_WINNING_RANK_MAP.put(FOURTH_PLACE.answerCount, FOURTH_PLACE);
    }

    private final int answerCount;
    private final int winningMoneyAmount;

    WinningRank(int answerCount, int winningMoneyAmount) {
        this.answerCount = answerCount;
        this.winningMoneyAmount = winningMoneyAmount;
    }

    public static List<WinningRank> getWinningRanksOf(Lottos lottos, WinningNumbers winningNumbers) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            winningRanks.add(getWinningRankOf(lotto, winningNumbers));
        }
        return winningRanks;
    }

    static WinningRank getWinningRankOf(Lotto lotto, WinningNumbers winningNumbers) {
        int correctAnswerCount = lotto.getEqualNumberCount(winningNumbers.getNumbers());
        return ANSWER_COUNT_WINNING_RANK_MAP.get(correctAnswerCount);
    }
}
