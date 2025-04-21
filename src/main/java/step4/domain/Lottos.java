package step4.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 묶음
 */
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    /**
     * 전부 자동으로 구매시
     */
    public static Lottos ofAutoCount(int count) {
        return new Lottos(generateLottosByCount(count));
    }

    /**
     * 일부 수동구매시
     */
    public static Lottos ofMixed(List<Lotto> manualLottos, int count) {
        List<Lotto> combined = new ArrayList<>(manualLottos);
        combined.addAll(generateLottosByCount(count));
        return new Lottos(combined);
    }

    private static List<Lotto> generateLottosByCount(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> Lotto.ofAuto())
            .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public String allLottoNumbersToString() {
        return lottos.stream()
            .map(Lotto::numbersToString)
            .collect(Collectors.joining("\n"));
    }

    public Map<Lotto, MatchResult> createMatchResultMap(LottoNumbers lottoNumbers, Integer bonusNumber) {
        Map<Lotto, MatchResult> matchResultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            matchResultMap.put(lotto, lotto.match(lottoNumbers, bonusNumber));
        }
        return matchResultMap;
    }
}
