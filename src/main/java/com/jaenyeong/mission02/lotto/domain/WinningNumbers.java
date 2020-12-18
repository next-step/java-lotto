package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;
import com.jaenyeong.mission02.lotto.domain.lottery.LotteryNumber;
import com.jaenyeong.mission02.lotto.domain.lottery.LotteryNumbers;

import java.util.List;

public class WinningNumbers {
    private final LotteryNumbers winningNumbers;
    private final LotteryNumber bonusNumber;

    private WinningNumbers(final LotteryNumbers winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = LotteryNumber.ofManual(bonusNumber);
    }

    public static WinningNumbers of(final List<Integer> winningNumbers, final int bonusNumber) {
        return new WinningNumbers(LotteryNumbers.ofManual(winningNumbers), bonusNumber);
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
