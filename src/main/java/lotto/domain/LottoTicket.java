package lotto.domain;

import java.util.Objects;

public class LottoTicket {

    private int autoQuantity;
    private int manualQuantity;

    private LottoTicket(int autoQuantity, int manualQuantity) {
        this.autoQuantity = autoQuantity;
        this.manualQuantity = manualQuantity;
    }

    public static LottoTicket of(int totalQuantity, int manualQuantity) {
        return new LottoTicket(totalQuantity - manualQuantity, manualQuantity);
    }

    public int getAutoQuantity() {
        return autoQuantity;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket ticket = (LottoTicket) o;
        return autoQuantity == ticket.autoQuantity &&
                manualQuantity == ticket.manualQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoQuantity, manualQuantity);
    }
}
