package lotto.dto;

import java.util.List;
import java.util.Objects;

public class BuyerData {
    private final Integer autoTicketCnt;
    private final Integer manualTicketCnt;
    private final List<TicketData> boughtTickets;

    public BuyerData(Integer autoTicketCnt, Integer manualTicketCnt, List<TicketData> boughtTickets) {
        this.autoTicketCnt = autoTicketCnt;
        this.manualTicketCnt = manualTicketCnt;
        this.boughtTickets = boughtTickets;
    }

    public Integer getAutoTicketCnt() {
        return autoTicketCnt;
    }

    public Integer getManualTicketCnt() {
        return manualTicketCnt;
    }

    public List<TicketData> getBoughtTickets() {
        return boughtTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerData that = (BuyerData) o;
        return Objects.equals(autoTicketCnt, that.autoTicketCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoTicketCnt);
    }
}
