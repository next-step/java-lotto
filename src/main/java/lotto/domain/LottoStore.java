package lotto.domain;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public Lottos buyAutoLotto(int amount){
        int count = calculateLottoCount(amount);

        return new Lottos();
    }

    private int calculateLottoCount(int amount){
        return amount / LOTTO_PRICE;
    }

}
