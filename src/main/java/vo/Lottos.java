package vo;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos+"";
    }

    public MatchingResults match(WinningLotto winningLotto) {
        MatchingResults result = new MatchingResults(lottos.size());
        for (Lotto userLotto : lottos) {
            result.add(winningLotto.match(userLotto));
        }
        return result;
    }
}
