package study.ascii92der.lotto.step3to5;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoResult> matchResults(WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();
        lottos.stream().map(lotto -> new LottoResult(lotto, winningLotto)).forEach(lottoResults::add);
        return lottoResults;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.toString()));
        return sb.toString();
    }
}
