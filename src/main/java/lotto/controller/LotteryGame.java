package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.Lottery;
import lotto.domain.LotteryMachine;

import java.util.*;

import static lotto.view.Lottery.printLotteries;
import static lotto.view.Statistics.printStatistics;
import static util.Random.generationRandom;

public class LotteryGame {

    public static void main() {
        String inputMoney = "30000";

        Set<Integer> winnerNumber = generationRandom();
        LotteryMachine lotteryMachine = new LotteryMachine(winnerNumber);
        Lotteries lotteries = new Lotteries(inputMoney);
        printLotteries(inputMoney);

        printStatistics(lotteries, lotteryMachine);
    }
}
