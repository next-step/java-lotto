package lotto.controller;

import lotto.model.domain.CountInfo;
import lotto.model.game.LotteryGame;
import lotto.model.domain.PurchaseInfo;
import lotto.model.result.LotteryGameResultDto;
import lotto.model.ticket.LotteryTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryGameApp {

    public static void main(String[] args) {
        try {
            PurchaseInfo purchaseInfo = InputView.getPurchaseInfo();
            CountInfo countInfo = InputView.getCountInfo(purchaseInfo);
            LotteryTickets lotteryTickets = new LotteryTickets(countInfo);
            ResultView.printTickets(countInfo, lotteryTickets.getTickets());
            LotteryGame lotteryGame = new LotteryGame(lotteryTickets, new LotteryGameResultDto(purchaseInfo.getAmount()));
            ResultView.printStatistics(lotteryGame.play());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " 게임을 종료합니다.");
        }
    }
}
