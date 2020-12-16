package com.jaenyeong.mission02.lotto;

import com.jaenyeong.mission02.lotto.domain.Rank;
import com.jaenyeong.mission02.lotto.domain.WinningNumbers;
import com.jaenyeong.mission02.lotto.domain.WinningStatistics;
import com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame;

import java.util.List;
import java.util.stream.Collectors;

import static com.jaenyeong.mission02.lotto.domain.LotteryShop.buyAutomatically;
import static com.jaenyeong.mission02.lotto.domain.lottery.LotteryGame.howManyBuyGame;
import static com.jaenyeong.mission02.lotto.view.UI.*;

public class LotteryRunner {
    private static final int BUY_NOTHING = 0;

    public void running() {
        final int buyPrice = scanBuyPrice();

        final int numberOfBuyGame = inputNumberOfBuyGame(buyPrice);

        if (numberOfBuyGame == BUY_NOTHING) {
            return;
        }

        final List<LotteryGame> games = ticketing(numberOfBuyGame);

        final List<Rank> lotteryRanks = searchWinningNumbers(games);

        printWinningStatistics(lotteryRanks, buyPrice);
    }

    private int inputNumberOfBuyGame(final int buyPrice) {
        final int numberOfBuyGame = howManyBuyGame(buyPrice);
        printNumberOfBuyGame(numberOfBuyGame);

        return numberOfBuyGame;
    }

    private List<LotteryGame> ticketing(final int numberOfBuyGame) {
        final List<LotteryGame> games = buyAutomatically(numberOfBuyGame);
        printLotteryNumbers(games);

        return games;
    }

    private List<Rank> searchWinningNumbers(final List<LotteryGame> games) {
        final WinningNumbers winningNumbers = WinningNumbers.of(scanWinningNumbers());

        return games.stream()
            .map(winningNumbers::checkWinTheLottery)
            .collect(Collectors.toList());
    }

    private void printWinningStatistics(final List<Rank> lotteryRanks, final int buyPrice) {
        final WinningStatistics winningStatistics = WinningStatistics.of(lotteryRanks, buyPrice);
        printResultStatistics(winningStatistics.getPrintFormatWinningResultStatistics());
        printPrize(winningStatistics.getPrintFormatPrizeRate());
    }
}
