package lotto.domain;

import java.util.List;
import lotto.domain.dto.LottoCalculationDTO;

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

    public List<Lotto> getLottos() {
        return purchaseLottos.lottos();
    }

    public int getLottosCalculation() {
        return purchaseLottos.calculateLotto(purchaseMoney);
    }

    public LottoCalculationDTO getPurchaseLottos(List<Lotto> lotto, Money money) {
        return purchaseLottos.purchaseLottos(lotto, money);
    }

}
