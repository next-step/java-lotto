package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.unmodifiableList;

public class Lottos {

    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printAllLottos() {
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public LottoResults getResults(Lotto lastWinningLotto) {
        return new LottoResults(createLottoResults(lastWinningLotto));
    }

    private Map<LottoRankEnum, Integer> createLottoResults(Lotto lastWinningLotto) {
        Map<LottoRankEnum, Integer> results = new HashMap<>();
        results.put(LottoRankEnum.FIFTH, countMatchingNumbers(lastWinningLotto, THREE));
        results.put(LottoRankEnum.FOURTH, countMatchingNumbers(lastWinningLotto, FOUR));
        results.put(LottoRankEnum.THIRD, countMatchingNumbers(lastWinningLotto, FIVE));
        results.put(LottoRankEnum.FIRST, countMatchingNumbers(lastWinningLotto, SIX));
        return results;
    }

    private int countMatchingNumbers(Lotto lastWinningLotto, int findingNumber) {
        return (int) lottos.stream()
                .mapToInt(lotto -> lotto.countMatchingNumbers(lastWinningLotto.getLottoNumbers()))
                .filter(matchingNumbers -> matchingNumbers == findingNumber)
                .count();
    }
}
