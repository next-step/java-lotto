package lotto;

public class LottoBuy {
    public static final int LOTTO_COST = 1000;

    public Lottos buyLotto(int buyPay) {
        Lottos lottos = new Lottos();
        for (int count = 0; count < buyPay / LOTTO_COST; count++) {
            lottos.createRandomLotto();
        }
        return lottos;
    }

    public Lottos buyOneRandomLotto(LottoRandomNumber lottoRandomNumber) {
        return new Lottos(new Lotto(lottoRandomNumber));
    }
}
