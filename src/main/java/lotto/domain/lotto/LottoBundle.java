package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    List<BasicLotto> lottos;

    public LottoBundle() {
        lottos = new ArrayList<>();
    }

    public void add(BasicLotto lotto) {
        this.lottos.add(lotto);
    }

    public void addAll(LottoBundle lottoBundle) {
        this.lottos.addAll(lottoBundle.lottos);
    }

    public List<BasicLotto> getLottos() {
        return lottos;
    }
}
