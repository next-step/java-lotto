package lotto.controller;

import lotto.domain.LottoAnswer;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoBuyerGenerator;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBunch;
import lotto.domain.LottoTicketGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private InputView input;
    private OutputView output;

    public Controller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public LottoTicketBunch buyTickets() {
        LottoBuyer buyer = LottoBuyerGenerator.generateLottoBuyer(
            input.inputTotalCost(), input.inputManualTicketCnt()
        );

        input.inputManualTicketsNumbers();
        manualBuy(buyer);
        autoBuy(buyer);
        output.printBuyData(
            buyer.getBuyData()
        );

        return buyer.getBoughtTickets();
    }

    private void manualBuy(LottoBuyer buyer) {
        while (buyer.shouldBuyManualTicket()) {
            buyer.buyManualTicket(
                input.inputTicketsNumbers()
            );
        }
    }

    private void autoBuy(LottoBuyer buyer) {
        buyer.buyAutoTickets();
    }

    public LottoAnswer generateAnswer() {
        return new LottoAnswer(
            LottoTicketGenerator.generateManualTicket(
                input.inputAnswerNumbers()
            ),
            new LottoNumber(
                input.inputBonusNumber()
            )
        );
    }

    public void playGame(LottoTicketBunch ticketBunch, LottoAnswer answer) {
        LottoGame game = new LottoGame(answer, ticketBunch);
        output.printScoreBoardData(
            game.calcScoreBoard().getScoreBoardData()
        );
    }
}
