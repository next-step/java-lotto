package lotto.domain;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public Lotto buyAutoLotto(int amount){
        int count = calculateLottoCount(amount);

        LottoGenerator lottoGenerator = new LottoGenerator();

        return new Lotto(count, lottoGenerator);
    }

    private int calculateLottoCount(int amount){
        return amount / LOTTO_PRICE;
    }

}
