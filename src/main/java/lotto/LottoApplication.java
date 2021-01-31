package lotto;

import lotto.domain.LottoAnswer;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoBuyerGenerator;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        // Buy Lotto Tickets
        LottoBuyer buyer = LottoBuyerGenerator .generateLottoBuyer(
            input.inputTotalCost(), 0
        );
        buyer.buyAutoTickets();

        List<LottoTicket> tickets = buyer.getBoughtTickets();

        output.printBuyerData(buyer.getBuyerData());

        // Make Lotto Answer
        LottoAnswer answer = new LottoAnswer(
            LottoTicketGenerator.generateManualTicket(
                input.inputAnswerNumbers()
            ),
            new LottoNumber(
                input.inputBonusNumber()
            )
        );

        // Play Lotto Game
        LottoGame game = new LottoGame(answer, tickets);
        output.printScoreBoardData(
            game.calcScoreBoard().getScoreBoardData()
        );
    }
}
