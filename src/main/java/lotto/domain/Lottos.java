package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final int WINNER_BOUNDARY = 3;
    private final List<Lotto> lottos = new ArrayList<>();

    public int generateLottosFromStrategy(GenerateNumberStrategy strategy, int count) {
        lottos.addAll(Stream.generate(() -> new Lotto(strategy))
                .limit(count)
                .collect(Collectors.toList()));
        return lottos.size();
    }

    public int generateLottoFromUserInput(String input) {
        lottos.add(new Lotto(input));
        return lottos.size();
    }

    public Map<Ranking, Integer> countWinningLotto(Lotto winningLotto) {
        Map<Ranking, Integer> winningLottoMap = new HashMap<>();
        lottos.stream().map(lotto -> lotto.countMatchNumber(winningLotto))
                .forEach(count -> saveWinner(winningLottoMap, count));
        return winningLottoMap;
    }

    private void saveWinner(Map<Ranking, Integer> winningLottoMap, Integer count) {
        if (count >= WINNER_BOUNDARY) {
            Ranking ranking = Ranking.findMatchRanking(count);
            winningLottoMap.put(ranking, winningLottoMap.getOrDefault(ranking, 0) + 1);
        }
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
