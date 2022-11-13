package step3;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lotto) {
        validate(lotto);
        this.lottos = lotto;
    }

    public int results(Lotto lotto, WinningLotto bonusLotto) {
        return bonusLotto.count(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validate(List<Lotto> lotto) {
        if (lotto.size() < 1) {
            throw new IllegalArgumentException("구매한 로또 개수가 1 미만일 수는 없습니다.");
        }
    }
}
