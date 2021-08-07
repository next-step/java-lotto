package lotto.controller;

import lotto.domain.model.LottoMoney;
import lotto.domain.model.LottoNumber;
import lotto.dto.LottoResult;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningTicket;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private static WinningTicket askForWinningTicket() {
        String ticketText = InputView.winningLotto();
        String bonusText = InputView.bonusBall();
        LottoTicket lottoTicket = LottoTicket.of(ticketText);
        LottoNumber bonusNumber = LottoNumber.of(bonusText);
        return WinningTicket.of(lottoTicket, bonusNumber);
    }

    public static void run() {
        // money
        int amountOfMoney = InputView.howMuch();
        LottoMoney money = LottoMoney.of(amountOfMoney);

        // tickets
        int numberOfTickets = money.numberOfTickets();
        LottoTickets lottoTickets = LottoService.generateRandomTickets(numberOfTickets);
        ResultView.printLottoTickets(lottoTickets.getTicketDtos());

        // winning ticket
        WinningTicket winningTicket = askForWinningTicket();
        LottoResult lottoResult = lottoTickets.match(winningTicket);
        ResultView.printLottoResult(lottoResult);

        // profit
        double profitMargin = LottoService.profitMargin(lottoResult, money);
        ResultView.printProfit(profitMargin);
    }
}
