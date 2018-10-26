package lotto.domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public MatchingResults match(WinningLotto winningLotto) {
        MatchingResults result = new MatchingResults(lottos.size());
        for (Lotto userLotto : lottos) {
            result.add(winningLotto.match(userLotto));
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "Lottos [lottos=" + lottos + "]";
    }
}
