package vo;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        lottos.stream().forEach(System.out::println);
        return "";
//        return lottos.toString();
    }

    public MatchingResults match(WinningLotto winningLotto) {
        MatchingResults result = new MatchingResults(lottos.size());
        for (Lotto userLotto : lottos) {
            result.add(winningLotto.match(userLotto));
        }
        return result;
    }

    public int count() {
        return lottos.size();
    }
}
