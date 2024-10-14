package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.generate.LottoGenerate;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView(new Lotto(new LottoTickets(), new LottoGenerate()));
        int purchaseLottoCount = resultView.purchaseResultView(inputView.questionInputMoney());
        String winnerLottoNumber = inputView.questionWinnerNumber();
        LottoTicket lastWeekWinningNumbers = new LottoTicket(winnerLottoNumber);
        resultView.statisticsResultView(lastWeekWinningNumbers, purchaseLottoCount);

    }

}
