package study.step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoWin result(Lotto winLotto, LottoNumber bonusBall) {
        LottoWin lottoWin = new LottoWin();
        lottos.forEach(lotto -> lottoWin.hit(lotto.match(winLotto.getLottoNumbers()), lotto.matchBonus(bonusBall)));
        return lottoWin;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
