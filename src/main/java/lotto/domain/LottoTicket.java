package lotto.domain;

import java.util.Objects;

public class LottoTicket {

    private int quantity;
    private int manualCount;

    public LottoTicket(int quantity) {
        this.quantity = quantity;
    }

    public void spend() {
        if(quantity == 0 ){
            throw new IllegalArgumentException();
        }
        quantity--;
        manualCount++;
    }

    public int getRemainCount() {
        return quantity;
    }

    public int getManualCount() {
        return manualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket ticket = (LottoTicket) o;
        return quantity == ticket.quantity &&
                manualCount == ticket.manualCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, manualCount);
    }
}
