package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoBuyerGenerator;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        LottoBuyer buyer = LottoBuyerGenerator.generateLottoBuyer(input.inputTotalCost());
        output.printTicketCnt(buyer.getLottoTicketCntDTO());
        while (buyer.canBuyTicket()) {
            LottoTicket ticket = buyer.buyTicket();
            output.printTicket(ticket.getLottoTicketDTO());
        }
    }
}
