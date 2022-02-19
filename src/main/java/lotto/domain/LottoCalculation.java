package lotto.domain;

import java.util.List;

public class LottoCalculation {

    private Lottos purchaseLottos;
    private Money purchaseMoney;

    public LottoCalculation(Money value) {
        this(new Lottos(), value);
    }

    public LottoCalculation(Lottos lottos, Money money) {
        purchaseMoney = money;
        purchaseLottos = lottos;
    }

    public List<Lotto> getLotto() {
        return purchaseLottos.lottos();
    }

    public Lottos getLottos() {
        return purchaseLottos;
    }

    public int getPurchaseLottos(List<Lotto> lotto, Money money) {
        return purchaseLottos.purchaseLottos(lotto, money);
    }

    public int getLottosCalculation() {
        return purchaseLottos.calculateLotto(purchaseMoney);
    }
}
