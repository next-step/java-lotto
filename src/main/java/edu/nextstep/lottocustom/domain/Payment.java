package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.exception.PaymentIllegalArgumentException;

public class Payment {

    public static final int TICKET_PRICE = 1_000;

    private final int possibleTickets;

    public Payment(int payment) {
        validateUnderAUnitPrice(payment);
        validateDivideUnitPrice(payment);

        this.possibleTickets = payment/TICKET_PRICE;
    }

    private static void validateUnderAUnitPrice(int payment) {
        if (payment < TICKET_PRICE) {
            throw new PaymentIllegalArgumentException("최소 입력 가능 금액 미달. 최소 입력 금액 : " + TICKET_PRICE + " 원");
        }
    }

    private static void validateDivideUnitPrice(int payment) {
        if ((payment % TICKET_PRICE) != 0) {
            throw new PaymentIllegalArgumentException("개 당 금액 " + TICKET_PRICE + " 원으로 해당 단위로 입력 필요.");
        }
    }

    public void validateOverPossibleTickets(int numberOfCustomTickets) {
        if (numberOfCustomTickets > possibleTickets) {
            throw new PaymentIllegalArgumentException("금액이 모자랍니다. 개 당 금액 : " + TICKET_PRICE + "원");
        }
    }

    public int countOfTickets() {
        return possibleTickets;
    }
}
