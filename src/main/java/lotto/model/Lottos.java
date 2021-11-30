package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.utils.LottoNumberGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int lottoCount) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Result makeResult(WinningLotto winningLotto) {
        Result result = new Result();
        lottos.stream()
              .map(lotto -> makeRank(lotto, winningLotto))
              .forEach(matchedCount -> result.add(matchedCount));
        return result;
    }

    private Rank makeRank(Lotto lotto, WinningLotto winningLotto) {
        return Rank.from(winningLotto.matchCount(lotto), winningLotto.hasBonusNumber(lotto));
    }
}
