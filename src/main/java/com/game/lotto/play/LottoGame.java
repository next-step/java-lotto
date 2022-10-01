package com.game.lotto.play;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.MyTickets;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

public class LottoGame {
    private MyTickets myTickets;

    public void playGameByUserInput() {
        long inputPrice = InputView.inputPrice();
        buyTickets(inputPrice);
        Ticket winnerTicket = generateWinnerTicket(new ManualLottoNumberGenerator(InputView.inputLastWinnerNumber()));
        compareWithWinnerTicketAndGetEarningRates(winnerTicket, inputPrice);
    }

    private Ticket generateWinnerTicket(LottoNumberGenerator generator) {
        return new Ticket(generator);
    }

    public long buyTickets(long inputPrice) {
        long ticketCount = inputMoneyAndGetTicketCount(inputPrice);
        myTickets = new MyTickets(ticketCount);
        return ticketCount;
    }

    private long inputMoneyAndGetTicketCount(long inputPrice) {
        long ticketCount = inputPrice / Ticket.PRICE_OF_TICKET_UNIT;
        ResultView.printOutputCountMessage(ticketCount);
        return ticketCount;
    }

    public double compareWithWinnerTicketAndGetEarningRates(Ticket winnerTicket, long inputPrice) {
        myTickets.updateStrikesWithWinnerTicket(winnerTicket);
        return getEarningRates(inputPrice);
    }

    private double getEarningRates(long inputPrice) {
        ResultView.printResultMessage();
        EarningRates earningRates = new EarningRates(inputPrice, myTickets);
        return earningRates.calculateEarningRatesAndPrintResults();
    }
}
