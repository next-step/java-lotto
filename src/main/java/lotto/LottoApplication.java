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

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        LottoBuyer buyer = LottoBuyerGenerator.generateLottoBuyer(input.inputTotalCost());
        output.printTicketCnt(buyer.getLottoTicketCntDTO());

        List<LottoTicket> tickets = new ArrayList<>();
        while (buyer.canBuyTicket()) {
            LottoTicket ticket = buyer.buyTicket();
            output.printTicket(ticket.getLottoTicketDTO());
            tickets.add(ticket);
        }

        LottoAnswer answer = new LottoAnswer(
            LottoTicketGenerator.generateManualTicket(
                input.inputAnswerNumbers()
            ),
            new LottoNumber(
                input.inputBonusNumber()
            )
        );

        LottoGame game = new LottoGame(answer, tickets);
        output.printScoreBoardData(
            game.calcScoreBoard().getScoreBoardData()
        );
    }
}
