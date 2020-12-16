package com.jaenyeong.mission02.lotto.domain;

import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.List;

public class WinningNumbers {
    private LotteryGame winningNumbers;

    private WinningNumbers(final LotteryGame winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(final List<Integer> winningNumbers) {
        return new WinningNumbers(LotteryGame.ofManual(winningNumbers));
    }

    public Rank checkWinTheLotteryWithBonus(final LotteryGame otherLotteryGame, final int bonusNumber) {
        return this.winningNumbers.checkWinTheLotteryWithBonus(otherLotteryGame, bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
            "winningNumbers=" + winningNumbers +
            '}';
    }
}
