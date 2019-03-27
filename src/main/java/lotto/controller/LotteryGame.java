package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LotteryMachine;

import java.util.*;

import static lotto.view.Lottery.printLotteries;
import static lotto.view.ProfitRate.printStatistics;
import static util.Random.generateRandom;

public class LotteryGame {

    public static void main() {
        String inputMoney = "30000";
        int bonusNumber = 7;

        Set<Integer> winnerNumber = generateRandom();
        LotteryMachine lotteryMachine = new LotteryMachine(winnerNumber, bonusNumber);
        Lotteries lotteries = new Lotteries(inputMoney);
        printLotteries(inputMoney);

        printStatistics(lotteries, lotteryMachine);
    }
}
