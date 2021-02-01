package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.Ticket;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        String money = lottoController.getPriceFromUser();
        List<Ticket> tickets = lottoController.purchaseTicket(money);
        String winningNumber = lottoController.getWinningNumberFromUser();
        String bonusNumber = lottoController.getBonusNumberFromUser();
        lottoController.returnFinalLottoResult(money, winningNumber, bonusNumber, tickets);
    }
}
