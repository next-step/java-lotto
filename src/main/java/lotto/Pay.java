package lotto;

import java.util.Objects;

public class Pay {
    private final int pay;

    public Pay(int pay) {
        if(pay < LottoValidationUtils.LOTTO_COST){
            throw new IllegalArgumentException("구매금액은 천원이상입니다.");
        }
        this.pay = pay;
    }

    public int countBuyLotto(int lottoCost) {
        return this.pay / lottoCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pay pay1 = (Pay) o;
        return pay == pay1.pay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pay);
    }
}
