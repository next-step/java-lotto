package study.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;
    private LottoWin lottoWin;

    public LottoMachine() {
        lottos = new ArrayList<>();
        lottoWin = new LottoWin();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int purchase(int amount) {
        int count = amount / LOTTO_PRICE;
        for(int i=0; i<count; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return lottos.size();
    }

    public LottoWin result(Lotto winLotto) {
        lottos.forEach(lotto -> lottoWin.hit(lotto.match(winLotto.getLottoNumbers())));
        return lottoWin;
    }
}
