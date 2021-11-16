package lotto.controller;

import lotto.model.LotteryTicket;
import lotto.model.LotteryTicketGenerator;
import lotto.model.LotteryTickets;
import lotto.model.PurchaseInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameApp {

    public static void main(String[] args) {
        try {
            int amount = InputView.getIntValue("구입금액을 입력해 주세요.");
            PurchaseInfo purchaseInfo = new PurchaseInfo(amount);
            ResultView.purchaseCount(purchaseInfo.getLottoCount());
            LotteryTickets tickets = new LotteryTickets(purchaseInfo.getLottoCount());
            for(LotteryTicket ticket : tickets.getTickets()){
                System.out.println(ticket.getNumbers());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " 게임을 종료합니다.");
        }
    }

}
