package lotto.dto;

import java.util.Objects;

public class BuyerData {
    private final Integer ticketCnt;

    public BuyerData(Integer ticketCnt) {
        this.ticketCnt = ticketCnt;
    }

    public Integer getTicketCnt() {
        return ticketCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerData that = (BuyerData) o;
        return Objects.equals(ticketCnt, that.ticketCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCnt);
    }
}
