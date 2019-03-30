package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LotteryNo;
import lotto.domain.WinnerLottery;

import java.util.*;

import static lotto.view.Lottery.printLotteries;
import static lotto.view.ProfitRate.printStatistics;
import static util.Random.generateRandom;

public class LotteryGame {

    public static void main() {
        String inputMoney = "30000";
        int bonusNumber = 7;

        Set<LotteryNo> winnerNumber = generateRandom();
        Lotteries lotteries = new Lotteries(inputMoney);
        WinnerLottery winnerLottery = new WinnerLottery(winnerNumber, bonusNumber);
        printLotteries(inputMoney);

        printStatistics(lotteries, winnerLottery);
    }
}
