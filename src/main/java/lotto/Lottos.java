package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public MatchingResults match(WinningLotto winningLotto) {
        MatchingResults result = new MatchingResults(getLottoCount());
        for (Lotto userLotto : lottos) {
            result.add(winningLotto.match(userLotto));
        }
        return result;
    }

    @Override
    public String toString() {
        lottos.stream().forEach(System.out::println);
        return "";
    }
}
