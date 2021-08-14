/*
 * TicketMaker.java
 *
 * v0.1 ,  2021.08.14
 */

package edu.nextstep.lottoauto;

import java.util.ArrayList;
import java.util.List;

public class TicketMaker {

    private static final int PRICE_PER_ONE_TICKET = 1000;

    private int makingCount;

    public static TicketMaker create() {
        return new TicketMaker();
    }

    public List<LottoTicket> makeTickets(int payment) {
        validateMinPayment(payment);
        validatePaymentUnit(payment);

        initMakingCount(payment);

        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (makingCount > 0) {
            lottoTickets.add(LottoTicket.create());
            makingCount--;
        }

        return lottoTickets;
    }

    private void initMakingCount(int payment) {
        this.makingCount = payment / PRICE_PER_ONE_TICKET;
    }

    private void validatePaymentUnit(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000 원 단위로 입력 가능합니다.");
        }
    }

    private void validateMinPayment(int payment) {
        if (payment < 1000) {
            throw new IllegalArgumentException("최소 1,000원 부터 입력 가능합니다.(1장에 1,000원)");
        }
    }
}
