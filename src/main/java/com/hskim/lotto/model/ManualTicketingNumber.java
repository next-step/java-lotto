package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoTicketingExceptionMessage;

import java.util.Objects;

public class ManualTicketingNumber {

    private int ticketingNum;

    public ManualTicketingNumber(int ticketingNum) {
        validateNonNegative(ticketingNum);
        this.ticketingNum = ticketingNum;
    }

    private void validateNonNegative(int ticketingNum) {
        if (ticketingNum < 0) {
            throw new IllegalArgumentException(LottoTicketingExceptionMessage.NEGATIVE_TICKETING_NUMBER.getMessage());
        }
    }

    public int getTicketingNum() {
        return ticketingNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManualTicketingNumber)) return false;
        ManualTicketingNumber that = (ManualTicketingNumber) o;
        return ticketingNum == that.ticketingNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketingNum);
    }
}
