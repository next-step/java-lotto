package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.List;

public class WinningNumbers {
    private final LotteryGame winningNumbers;
    private final int bonusNumber;

    private WinningNumbers(final LotteryGame winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(final List<Integer> winningNumbers, final int bonusNumber) {
        return new WinningNumbers(LotteryGame.ofManual(winningNumbers), bonusNumber);
    }

    public Rank matchWinningNumbers(final LotteryGame otherLotteryGame) {
        final boolean matchBonusNumber = otherLotteryGame.containBonusNumber(bonusNumber);
        final int matchNumberOfWinningNumbers = otherLotteryGame.matchWinningNumber(winningNumbers);

        return Rank.valueOf(matchBonusNumber, matchNumberOfWinningNumbers);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
            "winningNumbers=" + winningNumbers +
            '}';
    }
}
