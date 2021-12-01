package lotto.controller;

import lotto.domain.Tickets;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Lottery {

    public void draw() {
        InputView inputView = new InputView();
        String price = inputView.questionPrice();

        InputInfo inputInfo = new InputInfo(price);
        int ticketCount = inputInfo.getTicketCount();

        Tickets tickets = new Tickets(ticketCount);
        ResultView resultView = new ResultView();

        resultView.printTickets(tickets);
    }


}
