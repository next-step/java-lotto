package lotto;


import lotto.model.Lottos;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public static Lottos buy(int money, int manualLottoNumber) {
        return Lottos.getRandomLottos(getLottoNum(money) - manualLottoNumber);
    }

    private static int getLottoNum(int input) {
        return input / LOTTO_PRICE;
    }

}
