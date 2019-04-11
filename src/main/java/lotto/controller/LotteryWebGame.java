package lotto.controller;

import lotto.domain.WebLottery;

import static spark.Spark.port;

public class LotteryWebGame {

    public static void main(String [] args) {
        WebLottery webLottery = new WebLottery();

        port(8080);
        webLottery.getMoneyAndLotteries();
        webLottery.postLotteryInfo();
        webLottery.postShowResult();
    }
}
