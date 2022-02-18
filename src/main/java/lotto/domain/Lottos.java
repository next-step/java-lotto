package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.lottogenerator.LottoGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos withLottoGenerator(LottoGenerator lottoGenerator, int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottos.add(lottoGenerator.get());
        }
        return new Lottos(lottos);
    }

    public static Lottos withListLotto(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<String> getLottos() {
        List<String> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(lotto.toString());
        }
        return result;
    }

    public Map<Rank, Integer> mapResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = initResult();

        for (Lotto lotto : lottos) {
            Rank rank = getRank(winningLotto, lotto);
            if (rank == Rank.NONE) continue;
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            result.put(rank, 0);
        }

        return result;
    }

    private Rank getRank(WinningLotto winningLotto, Lotto userLotto) {
        int matchCount = winningLotto.getMatchCount(userLotto);
        boolean matchBonus = winningLotto.getMatchBonus(userLotto);
        return Rank.find(matchCount, matchBonus);
    }

    public List<Lotto> get() {
        return this.lottos;
    }
}
