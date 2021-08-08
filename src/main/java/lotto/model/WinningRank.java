package lotto.model;

import java.util.*;

public enum WinningRank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000);

    private static final Map<Integer, WinningRank> ANSWER_COUNT_WINNING_RANK_MAP = new HashMap<>();

    static {
        ANSWER_COUNT_WINNING_RANK_MAP.put(FIRST_PLACE.answerCount, FIRST_PLACE);
        ANSWER_COUNT_WINNING_RANK_MAP.put(THIRD_PLACE.answerCount, THIRD_PLACE);
        ANSWER_COUNT_WINNING_RANK_MAP.put(FOURTH_PLACE.answerCount, FOURTH_PLACE);
        ANSWER_COUNT_WINNING_RANK_MAP.put(FIFTH_PLACE.answerCount, FIFTH_PLACE);
    }

    private final int answerCount;
    private final int winningMoneyAmount;

    WinningRank(int answerCount, int winningMoneyAmount) {
        this.answerCount = answerCount;
        this.winningMoneyAmount = winningMoneyAmount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public int getWinningMoneyAmount() {
        return winningMoneyAmount;
    }

    public static List<WinningRank> findWinningRanks(Lottos lottos, LotteryNumbers lotteryNumbers) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            winningRanks.add(findWinningRank(lotto, lotteryNumbers));
        }
        return winningRanks;
    }

    static WinningRank findWinningRank(Lotto lotto, LotteryNumbers lotteryNumbers) {
        WinningNumbers winningNumbers = lotteryNumbers.getWinningNumbers();
        int answerCount = lotto.findEqualNumberCount(winningNumbers);
        WinningRank winningRank = ANSWER_COUNT_WINNING_RANK_MAP.get(answerCount);
        LottoNumber bonusNumber = lotteryNumbers.getBonusNumber();

        if (isThirdPlace(winningRank) && lotto.contains(bonusNumber)) {
            return SECOND_PLACE;
        }
        return winningRank;
    }

    private static boolean isThirdPlace(WinningRank winningRank) {
        return THIRD_PLACE == winningRank;
    }
}
