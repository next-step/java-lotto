package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoMatchResult getResult(LottoNums winNums, int totalPrice) {
        final LottoMatchResult lottoMatchResult = new LottoMatchResult(totalPrice);
        this.lottos.forEach(lotto -> lotto.getLottoMatch(winNums)
            .ifPresent(lottoMatch -> lottoMatchResult.increment(lottoMatch)));

        return lottoMatchResult;
    }
}
