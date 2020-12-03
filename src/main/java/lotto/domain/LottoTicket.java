package lotto.domain;

import java.util.Objects;

public class LottoTicket {

    private int quantity;
    private int autoCount;
    private int manualCount;

    public LottoTicket(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void manualSpend() {
        if(quantity == 0) {
            throw new IllegalArgumentException();
        }
        quantity--;
        manualCount++;
    }

    public void autoSpend() {
        if(quantity == 0 ){
            throw new IllegalArgumentException();
        }
        quantity--;
        autoCount++;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }


}
