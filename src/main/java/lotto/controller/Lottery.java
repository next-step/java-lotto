package lotto.controller;

import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.view.InputInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Lottery {

    private InputView inputView;
    private ResultView resultView;

    public Lottery() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void draw() {
        String price = inputView.questionPrice();

        InputInfo inputInfo = new InputInfo(price);
        int ticketCount = inputInfo.getTicketCount();
        Tickets tickets = new Tickets(ticketCount);

        resultView.printTickets(tickets);

        winner(inputInfo);
    }

    private void winner(InputInfo inputInfo) {
        String answerText = inputView.questionAnswer();
        List<Integer> answerList = inputInfo.getAnswer(answerText);
        Ticket answer = new Ticket(answerList);
    }

}
