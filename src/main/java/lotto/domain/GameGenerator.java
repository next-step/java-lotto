package lotto.domain;

import lotto.domain.strategy.NumberGenerateStrategy;
import lotto.dto.OrderSheet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class GameGenerator {

  private static final int PRICE_PER_GAME = 1000;


  private final OrderSheet orderSheet;
  private final NumberGenerateStrategy numberGenerateStrategy;

  public GameGenerator(OrderSheet orderSheet, NumberGenerateStrategy numberGenerateStrategy) {
    this.orderSheet = orderSheet;
    this.numberGenerateStrategy = numberGenerateStrategy;
  }

  private static long computeNumberOfGames(long purchasingAmount) {
    return purchasingAmount / PRICE_PER_GAME;
  }

  public LottoGames generateNewLottoGames() {
    List<LottoGame> manualGames = generateGivenManualGames(orderSheet.getManualOrderedLottoNumbers());
    List<LottoGame> autoGames = generateGivenCountRandomGames(computeAutoGameCount(manualGames.size()));
    manualGames.addAll(autoGames);
    return new LottoGames(manualGames);
  }

  private long computeAutoGameCount(int manualGameCount) {
    return computeNumberOfGames(orderSheet.getPurchasingAmount()) - manualGameCount;
  }

  private List<LottoGame> generateGivenManualGames(List<List<Integer>> manualNumbers) {
    return manualNumbers.stream()
            .map(this::createManualLottoGame)
            .collect(Collectors.toList());
  }

  public long peekTotalOrderedAmount() {
    return orderSheet.getPurchasingAmount();
  }

  public LottoGame createManualLottoGame(List<Integer> inputNumbers) {
    List<LottoNumber> lottoNumbers = inputNumbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
    return LottoGame.createManualGame(new LottoNumbers(lottoNumbers));
  }

  private List<LottoGame> generateGivenCountRandomGames(long count) {
    return LongStream.range(0, count)
                    .mapToObj(index -> createGameByRandomStrategy())
                    .collect(Collectors.toList());
  }

  private LottoGame createGameByRandomStrategy() {
    return LottoGame.createAutoGame(numberGenerateStrategy.generateNewNumbers());
  }
}
