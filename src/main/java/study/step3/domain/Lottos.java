package study.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public LottoWin result(Lotto winLotto) {
        LottoWin lottoWin = new LottoWin();
        lottos.forEach(lotto -> lottoWin.hit(lotto.match(winLotto.getLottoNumbers())));
        return lottoWin;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
