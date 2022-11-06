package step3;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lotto) {
        this.lottos = lotto;
    }

    public int results(Lotto lotto, BonusLotto bonusLotto) {
        return bonusLotto.getLotto().count(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
