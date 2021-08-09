package lotto.controller;

import java.util.List;
import lotto.domain.model.money.LottoMoney;
import lotto.domain.model.money.Payment;
import lotto.domain.model.ticket.LottoNumber;
import lotto.dto.LottoResult;
import lotto.domain.model.ticket.LottoTicket;
import lotto.domain.model.ticket.LottoTickets;
import lotto.domain.model.ticket.WinningTicket;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void run() {
        // amount of money
        int amountOfMoney = InputView.howMuch();
        LottoMoney money = LottoMoney.of(amountOfMoney);

        // number of manual tickets
        int countOfManual = InputView.countOfManual();
        Payment payment = Payment.of(money, countOfManual);

        // lotto tickets
        LottoTickets lottoTickets = askForTickets(countOfManual, payment);
        ResultView.printTickets(countOfManual, lottoTickets.getTicketDtos());

        // winning ticket
        WinningTicket winningTicket = askForWinningTickets();
        LottoResult lottoResult = lottoTickets.match(winningTicket);
        ResultView.printResult(lottoResult);

        // profit
        double profitMargin = LottoService.profitMargin(lottoResult, money);
        ResultView.printProfit(profitMargin);
    }

    private static WinningTicket askForWinningTickets() {
        // winning ticket
        LottoTicket winningTicket = LottoTicket.of(InputView.winningLotto());

        // bonus ball
        LottoNumber bonusNumber = LottoNumber.of(InputView.bonusBall());
        return WinningTicket.of(winningTicket, bonusNumber);
    }

    private static LottoTickets askForTickets(int countOfManual, Payment payment) {
        // manual tickets
        List<String> ticketStrings = InputView.manualTicketStrings(countOfManual);
        LottoTickets manualTickets = LottoService.mapToTickets(ticketStrings);

        // automatic tickets
        LottoTickets randomTickets = LottoService.generateRandomTickets(payment.countOfAutomatic());
        return LottoTickets.merge(manualTickets, randomTickets);
    }
}
