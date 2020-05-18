package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public LottoMatchResult getResult(LottoNums winNums) {
        final LottoMatchResult lottoMatchResult = new LottoMatchResult();
        this.lottos.forEach(lotto -> lottoMatchResult.increment(lotto.getLottoMatch(winNums)));

        return lottoMatchResult;
    }
}
