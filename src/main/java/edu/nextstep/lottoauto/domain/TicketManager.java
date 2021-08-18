package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.PaymentIllegalArgumentException;
import edu.nextstep.lottoauto.view.form.WinningResultForm;
import edu.nextstep.lottoauto.domain.ticketmaker.NumbersMaker;

import java.util.List;

public class TicketManager {

    private static final int TICKET_PRICE = 1_000;

    private final TicketMachine ticketMachine = new TicketMachine();

    public void createAndSaveTickets(int payment, NumbersMaker numbersMaker) {
        validateUnderAUnitPrice(payment);
        validateDivideUnitPrice(payment);

        int numberOfTickets = calculateNumberOfTicketsFrom(payment);
        ticketMachine.createAndSaveTickets(numberOfTickets, numbersMaker);
    }

    public List<Ticket> findTickets() {
        return ticketMachine.findTickets();
    }

    public WinningResultForm confirmWinningResult(String winningNumbersString) {
        Ticket winningTicket = ticketMachine.createCustomTicket(winningNumbersString);
        return ticketMachine.confirmWinningResult(winningTicket);
    }

    public int calculateNumberOfTicketsFrom(int payment) {
        return payment / TICKET_PRICE;
    }

    private void validateUnderAUnitPrice(int payment) {
        if (payment < TICKET_PRICE) {
            throw new PaymentIllegalArgumentException("최소 입력 가능 금액 미달. 최소 입력 금액 : " + TICKET_PRICE + " 원");
        }
    }

    private void validateDivideUnitPrice(int payment) {
        if ((payment % TICKET_PRICE) != 0) {
            throw new PaymentIllegalArgumentException("개 당 금액 " + TICKET_PRICE + " 원으로 해당 단위로 입력 필요.");
        }
    }
}
