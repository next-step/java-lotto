package lotto;

import lotto.domain.Numbers;
import lotto.domain.Ticket;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    public final int PRICE = 1000;
    private int amount;
    private final List<Ticket> ticketList = new ArrayList<>();

    public LottoSimulator(int amount) {
        this.amount = amount;
    }

    public void run() {
        while (this.amount >= PRICE) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
            LottoResultView.printTicket(ticket);
            this.amount -= PRICE;
        }

        LottoInputView lottoInputView = new LottoInputView();
        Numbers winningNumber = new Numbers(lottoInputView.inputStringLine("당첨번호를 입력해주세요."));

        for (Ticket ticket : this.ticketList) {
            ticket.match(winningNumber);
        }


    }

}
