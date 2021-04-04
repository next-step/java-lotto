package step02;

// controll 영역
public class LottoShop {
    private Lottos lottos;

    public Lottos buyLotto(int money, RandomNumberRule makeRandomNumberRule) throws Exception {
        lottos = new Lottos(LottoCount.calculationCount(money));
        lottos.makeLotto(makeRandomNumberRule);
        return lottos;
    }

}
