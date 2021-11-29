package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Result makeResult(WinningNumber winningNumber) {
        Result result = new Result();
        lottos.stream()
              .map(lotto -> makeRank(lotto, winningNumber))
              .forEach(matchedCount -> result.add(matchedCount));
        return result;
    }

    private Rank makeRank(Lotto lotto, WinningNumber winningNumber) {
        return Rank.from(winningNumber.matchCount(lotto), winningNumber.hasBonusNumber(lotto));
    }
}
