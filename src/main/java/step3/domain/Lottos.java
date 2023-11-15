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

    public LinkedHashMap<LottoRank, Integer> matchingResult(WinningNumbers winningNumbers) {
        LinkedHashMap<LottoRank, Integer> result = initResult();
        lottos.stream()
                .map(lotto -> LottoRank.valueOf(winningNumbers.matchCount(lotto), winningNumbers.containBonus(lotto)))
                .filter(LottoRank::isNotMiss)
                .forEach(lottoRank -> result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1));
        return result;
    }

    private static LinkedHashMap<LottoRank, Integer> initResult() {
        LinkedHashMap<LottoRank, Integer> result = new LinkedHashMap<>();
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));
        return result;
    }
}
