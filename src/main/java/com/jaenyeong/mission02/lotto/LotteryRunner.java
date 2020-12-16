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
    public static final int BUY_NOTHING = 0;

    public void running() {
        final int buyPrice = scanBuyPrice();

        final int numberOfBuyGame = howManyBuyGame(buyPrice);
        printNumberOfBuyGame(numberOfBuyGame);

        if (numberOfBuyGame == BUY_NOTHING) {
            return;
        }

        final List<LotteryGame> games = buyAutomatically(numberOfBuyGame);
        printLotteryNumbers(games);

        final WinningNumbers winningNumbers = WinningNumbers.of(scanWinningNumbers());

        final List<Rank> lotteryRanks = games.stream()
            .map(winningNumbers::checkWinTheLottery)
            .collect(Collectors.toList());

        final WinningStatistics winningStatistics = WinningStatistics.of(lotteryRanks, buyPrice);
        printResultStatistics(winningStatistics.getPrintFormatWinningResultStatistics());
        printPrize(winningStatistics.getPrintFormatPrizeRate());
    }
}
