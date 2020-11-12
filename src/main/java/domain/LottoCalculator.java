package domain;

import java.util.List;

public class LottoCalculator {
    private Lottos lottos;
    private final Money price = new Money(1000);

    public LottoCalculator(Money money) throws Exception {
        if(!hasEnoughMoney(money)){
            throw new Exception();
        }
        lottos = new Lottos(money.dividedBy(price));
    }

    private boolean hasEnoughMoney(Money money) {
        return money.isGreaterThan(price);
    }

    public Lottos getLottos(){
        return lottos;
    }

}
