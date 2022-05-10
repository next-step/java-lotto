package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
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

    public Map<Ranking, Integer> countWinningLotto(WinningLotto winningLotto) {
        Map<Ranking, Integer> winningLottoMap = new HashMap<>();
        lottos.stream().map(winningLotto::findMatchRanking)
                .forEach(matchResult -> saveWinner(winningLottoMap, matchResult));
        putDefaultValueToWinningMap(winningLottoMap);
        return winningLottoMap;
    }

    private void saveWinner(Map<Ranking, Integer> winningLottoMap, Ranking ranking) {
        winningLottoMap.put(ranking, winningLottoMap.getOrDefault(ranking, 0) + 1);
    }

    private void putDefaultValueToWinningMap(Map<Ranking, Integer> winningLottoMap) {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> winningLottoMap.putIfAbsent(ranking, 0));
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
