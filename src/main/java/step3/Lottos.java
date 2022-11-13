package step3;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lotto) {
        LottoValidator.validateLottosSize(lotto.size());
        this.lottos = lotto;
    }

    public int results(Lotto lotto, WinningLotto bonusLotto) {
        return bonusLotto.count(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
