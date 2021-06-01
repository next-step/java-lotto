package lotto.store;

public class ManualLottoStore extends LottoStore {

    private final int manualCount;

    public ManualLottoStore(Budget budget, int price, int manualCount) {
        super(budget, price);
        this.manualCount = manualCount;
        valid(budget, price, manualCount);
    }

    private static void valid(Budget budget, int price, int manualCount) {
        int count = budget.get() / price;
        if (count < manualCount) {
            throw new IllegalArgumentException("구매 가능 개수보다 많은 로또를 수동으로 입력할 수 없습니다");
        }
    }

}
