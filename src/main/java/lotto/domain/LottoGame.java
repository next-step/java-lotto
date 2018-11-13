package lotto.domain;


public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    public int getLottoCount(int budget) {
        int countByBudget = budget/LOTTO_PRICE;
        return countByBudget;
    }

    public BundleLotto makeLotto(int budget) {
        int countByBudget = getLottoCount(budget);

        BundleLotto lottos = new BundleLotto();
        for (int i = 0; i < countByBudget; i++) {
            lottos.addLotto(new Lotto());
        }
        return lottos;
    }
}
