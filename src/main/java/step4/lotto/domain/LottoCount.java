package step4.lotto.domain;

import java.util.Objects;

public class LottoCount {
    private static final int LOTTO_PRIZE = 1_000;
    private Money money;
    private Count manualCount;

    public LottoCount() {
        this.money = new Money();
        this.manualCount = new Count();
    }
    public LottoCount(int money, int count) {
        this.money = new Money(money);
        this.manualCount = new Count(count);
    }

    public Count autoCount() {
        Count totalCount = new Count(money.divide(LOTTO_PRIZE));

        if(totalCount.comapre(this.manualCount)){
            throw new IllegalArgumentException();
        }

        return totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return Objects.equals(money, that.money) && Objects.equals(manualCount, that.manualCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, manualCount);
    }
}
