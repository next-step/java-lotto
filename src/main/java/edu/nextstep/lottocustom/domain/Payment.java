package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.exception.PaymentIllegalArgumentException;

public class Payment {

    public static final int TICKET_PRICE = 1_000;
    public static final String UNDER_UNIT_PRICE_EXCEPTION_MESSAGE = "최소 입력 가능 금액 미달. 최소 입력 금액 : " + TICKET_PRICE + " 원";
    public static final String DIVIDE_UNIT_PRICE_EXCEPTION_MESSAGE = "개 당 금액 " + TICKET_PRICE + " 원으로 해당 단위로 입력 필요.";
    public static final String OVER_POSSIBLE_TICKETS_EXCEPTION_MESSAGE = "금액이 모자랍니다. 개 당 금액 : " + TICKET_PRICE + "원";

    private final int possibleTickets;

    public Payment(int payment) {
        validateUnderUnitPrice(payment);
        validateDivideUnitPrice(payment);

        this.possibleTickets = payment/TICKET_PRICE;
    }

    private static void validateUnderUnitPrice(int payment) {
        if (payment < TICKET_PRICE) {
            throw new PaymentIllegalArgumentException(UNDER_UNIT_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDivideUnitPrice(int payment) {
        if ((payment % TICKET_PRICE) != 0) {
            throw new PaymentIllegalArgumentException(DIVIDE_UNIT_PRICE_EXCEPTION_MESSAGE);
        }
    }

    public void validateOverPossibleTickets(int numberOfCustomTickets) {
        if (numberOfCustomTickets > possibleTickets) {
            throw new PaymentIllegalArgumentException(OVER_POSSIBLE_TICKETS_EXCEPTION_MESSAGE);
        }
    }

    public int countOfTickets() {
        return possibleTickets;
    }
}
