package com.game.lotto.play;

import com.game.lotto.count.TicketCount;
import com.game.lotto.money.Money;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.rate.EarningRates;
import com.game.lotto.ticket.*;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final Money inputPrice;
    private final MyTickets myTickets;

    public LottoGame(Money inputPrice) {
        this(inputPrice, new ArrayList<>());
    }

    public LottoGame(Money inputPrice, List<SelectedLottoNumbers> manualLottoNumbers) {
        this.inputPrice = inputPrice;
        TicketCount totalTicketCount = new TicketCount(inputPrice);
        TicketCount manualTicketCount = new TicketCount(manualLottoNumbers.size());
        TicketCount randomTicketCount = new TicketCount(totalTicketCount.getCount() - manualTicketCount.getCount());
        ResultView.printOutputCountMessage(totalTicketCount, manualTicketCount);
        this.myTickets = new MyTickets();
        this.myTickets.addManualTicketsByCount(manualLottoNumbers);
        this.myTickets.addRandomTicketsByCount(randomTicketCount);
    }

    public double compareWithWinnerTicketAndGetEarningRates(WinnerTicket winnerTicket) {
        TicketsByRanks ticketsByRanks = new TicketsByRanks(winnerTicket, myTickets.getTickets());
        return getEarningRates(ticketsByRanks);
    }

    private double getEarningRates(TicketsByRanks ticketsByRanks) {
        EarningRates earningRates = new EarningRates(inputPrice, ticketsByRanks);
        return earningRates.calculateEarningRatesAndPrintResults();
    }
}
