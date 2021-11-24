package lotto.controller;

import lotto.model.game.LotteryGame;
import lotto.model.domain.PurchaseInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryGameApp {

    public static void main(String[] args) {
        try {
            PurchaseInfo purchaseInfo = InputView.getPurchaseInfo();
            ResultView.printLotteryCount(purchaseInfo.getLotteryCount());
            LotteryGame lotteryGame = new LotteryGame(purchaseInfo);
            ResultView.printTickets(lotteryGame.getLotteryTickets());
            ResultView.printStatistics(lotteryGame.play());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " 게임을 종료합니다.");
        }
    }
}
