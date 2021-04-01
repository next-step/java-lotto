package step022;

// controll 영역
public class LottoShop {

    private Lottos lottos;

    public Lottos buyLotto(int money, MakeRandomNumberRule makeRandomNumberRule) {
        lottos = new Lottos();
        lottos.makeLotto(money, makeRandomNumberRule);
        return lottos;
    }
}
