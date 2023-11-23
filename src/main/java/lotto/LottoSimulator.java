package lotto;

import lotto.domain.Numbers;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoSimulator {
    private long amount;

    public LottoSimulator(long amount) {
        this.amount = amount;
    }

    public void run() {
        Tickets tickets = this.initTickets();
        LottoResultView.printTicket(tickets);

        Numbers winningNumber = inputWinningNumbers();

        Result result = new Result(tickets.makeStatistics(winningNumber), tickets.calcRateOfReturn(winningNumber));

        LottoResultView.printResult(result);
    }

    private Tickets initTickets() {
        Tickets tickets = new Tickets();

        while (this.amount >= Ticket.PRICE) {
            Ticket ticket = new Ticket();
            tickets.addTicket(ticket);
            this.amount -= Ticket.PRICE;
        }
        return tickets;
    }

    private static Numbers inputWinningNumbers() {
        LottoInputView lottoInputView = new LottoInputView();
        return new Numbers(lottoInputView.inputStringLine("당첨번호를 입력해주세요."));
    }

}
