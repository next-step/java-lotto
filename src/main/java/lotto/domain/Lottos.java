package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private static final int MIN_MATCH_COUNT = 3;

    public Lottos(int lottoCount) {
        this.lottos = createLotto(lottoCount);
    }

    private List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public MatchNumbers matchNumbers(List<Integer> winningNumbers) {
        MatchNumbers matchNumbers = new MatchNumbers();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningNumbers);
            matchNumbers.add(matchCount < MIN_MATCH_COUNT ? 0 : matchCount);
        }
        return matchNumbers;
    }
}
