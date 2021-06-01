package lotto.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lotto.LottoNumbers;
import lotto.generator.AutoLottoNumberGenerator;

public class LottoStore {

    protected final Budget budget;
    private final int price;
    protected final int count;

    public LottoStore(Budget budget, int price) {
        this.budget = budget;
        this.price = price;
        this.count = budget.get() / price;
        if (!isPurchasable(count)) {
            throw new IllegalArgumentException("Lotto를 구매할 수 없는 금액 입니다");
        }
    }

    public int purchaseCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoStore))
            return false;
        LottoStore lottoStore = (LottoStore)o;
        return budget == lottoStore.budget && price == lottoStore.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget, price);
    }

    public Ticket produceLotto() {
        List<LottoNumbers> result = new ArrayList<>();
        AutoLottoNumberGenerator autoGenerator = new AutoLottoNumberGenerator();
        for (int i = 0; i < purchaseCount(); i++) {
            LottoNumbers lotto = autoGenerator.generate();
            result.add(lotto);
        }
        return new Ticket(result, budget);
    }

    private static boolean isPurchasable(int count) {
        return count >= 1;
    }

}
