package lotto.domain;


public class LottoGame {

    public int getLottoCount(int budget) {
        int countByBudget = budget/1000;
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
