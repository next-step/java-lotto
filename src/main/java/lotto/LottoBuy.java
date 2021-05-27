package lotto;

public class LottoBuy {
    private Lottos lottos;
    private int buyCount;

    public Lottos buyLotto(Pay payForLotto) {
        this.buyCount = payForLotto.countBuyLotto(LottoValidationUtils.LOTTO_COST);
        lottos = new Lottos();
        for (int count = 0; count < buyCount; count++) {
            lottos.createRandomLotto();
        }
        return lottos;
    }

    public Lottos buyOneRandomLotto(LottoRandomNumber lottoRandomNumber) {
        return new Lottos(new Lotto(lottoRandomNumber));
    }
}
