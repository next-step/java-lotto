package lotto.service;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> generateRandomLottos(GenerateNumberStrategy strategy, Money randomPurchaseMoney) {
        generateLottosFromStrategy(strategy, randomPurchaseMoney.purchaseCount());
        return Collections.unmodifiableList(lottos);
    }

    private void generateLottosFromStrategy(GenerateNumberStrategy strategy, int count) {
        lottos.addAll(Stream.generate(() -> new Lotto(strategy))
                .limit(count)
                .collect(Collectors.toList()));
    }

    public List<Lotto> generateManualLottos(List<String> lottoList) {
        lottoList.forEach(this::generateLottoFromUserInput);
        return Collections.unmodifiableList(lottos);
    }

    private void generateLottoFromUserInput(String input) {
        lottos.add(new Lotto(input));
    }

    public RankingResult registerWinningNumbers(String numbers, String bonus) {
        Lotto lastWeekWinning = new Lotto(numbers);
        LottoNumber bonusNumber = LottoNumber.createNewNumber(bonus);

        return new RankingResult(countWinningLotto(new WinningLotto(lastWeekWinning, bonusNumber)));
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
}
