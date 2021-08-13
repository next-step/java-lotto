package lotto.model;

import java.util.*;

import static java.util.stream.Collectors.toList;

public enum WinningRank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000),
    MISS(0, false, 0);

    private static final int SINGLE_WINNING_RANK_COUNT = 1;
    private static final int FIRST_POSITION = 0;

    private final int matchedWinningNumberCount;
    private final boolean isBonusNumberMatchNecessary;
    private final int winningMoneyAmount;

    WinningRank(int matchedWinningNumberCount, boolean isBonusNumberMatchNecessary, int winningMoneyAmount) {
        this.matchedWinningNumberCount = matchedWinningNumberCount;
        this.isBonusNumberMatchNecessary = isBonusNumberMatchNecessary;
        this.winningMoneyAmount = winningMoneyAmount;
    }

    public static List<WinningRank> findWinningRanks(Lottos lottos, DrawNumbers drawNumbers) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            winningRanks.add(findWinningRank(lotto, drawNumbers));
        }
        return winningRanks;
    }

    private static WinningRank findWinningRank(Lotto lotto, DrawNumbers drawNumbers) {
        Lotto winningNumbers = drawNumbers.getWinningNumbers();
        int matchedWinningNumberCount = lotto.findMatchedNumberCount(winningNumbers);

        LottoNumber bonusNumber = drawNumbers.getBonusNumber();
        boolean containsBonusNumber = lotto.contains(bonusNumber);

        return findBy(matchedWinningNumberCount, containsBonusNumber);
    }

    private static WinningRank findBy(int matchedWinningNumberCount, boolean containsBonusNumber) {
        List<WinningRank> winningRanks = Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank.matchedWinningNumberCount == matchedWinningNumberCount)
                .collect(toList());

        if (winningRanks.size() == SINGLE_WINNING_RANK_COUNT) {
            return winningRanks.get(FIRST_POSITION);
        }

        return winningRanks.stream()
                .filter(winningRank -> winningRank.isBonusNumberMatchNecessary == containsBonusNumber)
                .findAny()
                .orElse(MISS);
    }

    public int getMatchedWinningNumberCount() {
        return matchedWinningNumberCount;
    }

    public int getWinningMoneyAmount() {
        return winningMoneyAmount;
    }

    public boolean isSecondPlace() {
        return this == SECOND_PLACE;
    }
}
