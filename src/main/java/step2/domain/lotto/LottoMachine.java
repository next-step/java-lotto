package step2.domain.lotto;

import step2.domain.statistics.Amount;

import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private static final int ZERO = 0;

    private final Price price;
    private final Amount manualAmount;

    public LottoMachine(Price price, Amount manualAmount) {
        this.price = price;
        if (price.amount().compareTo(manualAmount) < ZERO) {
            throw new RuntimeException("구매 수량은 구매 가격을 넘을 수 없습니다.");
        }
        this.manualAmount = manualAmount;
    }

    public Lottos manualIssue(List<Lotto> manualLottoNumberList) {
        return new Lottos(manualLottoNumberList);
    }

    public Lottos automaticIssue() {
        return new Lottos(price.spend(manualAmount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoMachine)) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(price, that.price) && Objects.equals(manualAmount, that.manualAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, manualAmount);
    }

    @Override
    public String toString() {
        final Amount autoAmount = price.spend(manualAmount);
        return "수동으로 " + manualAmount +
                "장, 자동으로 " + autoAmount +
                "개를 구매했습니다.";
    }
}
