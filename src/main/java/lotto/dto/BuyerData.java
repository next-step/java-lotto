package lotto.dto;

import java.util.Objects;

public class BuyerData {
    private final Integer autoTicketCnt;

    public BuyerData(Integer autoTicketCnt) {
        this.autoTicketCnt = autoTicketCnt;
    }

    public Integer getAutoTicketCnt() {
        return autoTicketCnt;
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
