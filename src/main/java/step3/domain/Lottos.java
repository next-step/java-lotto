package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoRank> matchingResult(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> LottoRank.valueOf(winningNumbers.matchCount(lotto), winningNumbers.containBonus(lotto)))
                .filter(LottoRank::isNotMiss)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

}
