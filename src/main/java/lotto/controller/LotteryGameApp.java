package lotto.controller;

import lotto.model.game.LotteryGame;
import lotto.model.domain.PurchaseInfo;
import lotto.model.result.LotteryGameResultDto;
import lotto.model.ticket.generator.AutoTicketGenerator;
import lotto.model.ticket.LotteryTickets;
import lotto.model.ticket.generator.ManualTicketGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryGameApp {

    public static void main(String[] args) {
        try {
            PurchaseInfo purchaseInfo = InputView.getPurchaseInfo();
            if(purchaseInfo.haveManualLottery()) InputView.inputManualLottery();
            LotteryTickets lotteryTickets = new LotteryTickets(purchaseInfo, new AutoTicketGenerator(), new ManualTicketGenerator());
            LotteryGameResultDto resultDto = new LotteryGameResultDto(purchaseInfo.getAmount());
            ResultView.printTickets(purchaseInfo, lotteryTickets.getTickets());
            LotteryGame lotteryGame = new LotteryGame(lotteryTickets, resultDto);
            ResultView.printStatistics(lotteryGame.play());
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " 게임을 종료합니다.");
        }
    }
}
