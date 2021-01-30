package lotto;

import java.util.List;
import java.util.Map;

import lotto.controller.LottoController;
import lotto.controller.Validator;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.Revenue;
import lotto.domain.Ticket;
import lotto.domain.WinningNumber;
import lotto.util.NumberUtils;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        String money = lottoController.getPriceFromUser();
        List<Ticket> tickets = lottoController.purchaseTicket(money);
        String winningNumber = lottoController.getWinningNumberFromUser();
        String bonusNumber = lottoController.getBonusNumberFromUser();
        lottoController.returnOutput(money, winningNumber, bonusNumber, tickets);
    }
}
