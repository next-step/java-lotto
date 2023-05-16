package model;

public class LottoStore {
    private static int LOTTO_PRICE = 1000;
    private LottoRandomGenerator lottoGenerator;

    public LottoStore() {
        lottoGenerator = new LottoRandomGenerator();
    }

    public Lottos buy(int buyAmount) {
        return lottoGenerator.generatorLotto(buyAmount / LOTTO_PRICE);
    }
}
