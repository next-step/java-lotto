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

    public Map<Ranking, Integer> countWinningLotto(Lotto winningLotto, LottoNumber bonus) {
        Map<Ranking, Integer> winningLottoMap = new HashMap<>();
        lottos.stream().map(lotto -> lotto.countMatchNumber(winningLotto, bonus))
                .forEach(matchResult -> saveWinner(winningLottoMap, matchResult));
        putDefaultValueToWinningMap(winningLottoMap);
        return winningLottoMap;
    }

    private void saveWinner(Map<Ranking, Integer> winningLottoMap, MatchResult matchResult) {
        Ranking ranking = Ranking.findMatchRanking(matchResult);
        if (ranking.isWinner())
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
}
