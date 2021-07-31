package step2;

public class LottoService {
    private static final int LOTTO_UNIT_PRICE = 1000;

    LottoNumbersBucket lottoNumbersBucket;

    public LottoService(int budget) {
        this.lottoNumbersBucket = new LottoNumbersBucket();
    }

    public static int getLottoQuantityByBudget(int budget) {
        return budget / LOTTO_UNIT_PRICE;
    }
}
