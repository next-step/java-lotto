package com.game.lotto.ticket;

import com.game.lotto.count.TicketCount;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTickets {
    private final List<MyTicket> myTickets;

    public MyTickets() {
        this.myTickets = new ArrayList<>();
    }

    public void addManualTicketsByCount(List<SelectedLottoNumbers> manualLottoNumbers) {
        for (SelectedLottoNumbers manualLottoNumber : manualLottoNumbers) {
            MyTicket ticketByGenerator = new MyTicket(new ManualLottoNumberGenerator(manualLottoNumber.getSelectedNumbers()));
            ResultView.printTicketNumbers(ticketByGenerator);
            this.myTickets.add(ticketByGenerator);
        }
    }

    public void addRandomTicketsByCount(TicketCount ticketCount) {
        for (int index = 0; index < ticketCount.getCount(); index++) {
            MyTicket ticketByGenerator = new MyTicket(new RandomLottoNumberGenerator());
            ResultView.printTicketNumbers(ticketByGenerator);
            this.myTickets.add(ticketByGenerator);
        }
    }

    public List<MyTicket> getTickets() {
        return myTickets.stream().collect(Collectors.toUnmodifiableList());
    }
}
