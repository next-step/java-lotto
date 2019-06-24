package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public LottoResult result(Lotto winningLotto) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            prizes.add(Prize.of(lotto.getMatchCount(winningLotto)));
        }
        return LottoResult.of(prizes);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
