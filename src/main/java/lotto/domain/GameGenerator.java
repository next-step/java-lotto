package lotto.domain;

import lotto.domain.strategy.RandomNumberGenerateStrategy;
import lotto.dto.OrderSheet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class GameGenerator {

  private static final int PRICE_PER_GAME = 1000;
  private static final String INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME = "최소 구입 금액은 %d원 이상입니다.";

  private final OrderSheet orderSheet;
  private final RandomNumberGenerateStrategy randomNumberGenerateStrategy;

  public GameGenerator(OrderSheet orderSheet, RandomNumberGenerateStrategy randomNumberGenerateStrategy) {
    this.orderSheet = orderSheet;
    this.randomNumberGenerateStrategy = randomNumberGenerateStrategy;
  }

  public LottoGames generateNewLottoGames() {
    return new LottoGames(generateGivenCountRandomGames(computeNumberOfGames(orderSheet.getPurchasingAmount())));
  }

  public long peekTotalOrderedAmount() {
    return orderSheet.getPurchasingAmount();
  }

  public LottoGame createLottoGame(List<Integer> inputNumbers) {
    List<LottoNumber> lottoNumbers = inputNumbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
    return new LottoGame(new LottoNumbers(lottoNumbers));
  }

  private List<LottoGame> generateGivenCountRandomGames(long count) {
    return LongStream.range(0, count)
                    .mapToObj(index -> createGameByRandomStrategy())
                    .collect(Collectors.toList());
  }

  private long computeNumberOfGames(long purchasingAmount) {
    if (purchasingAmount < PRICE_PER_GAME) {
      throw new IllegalArgumentException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, PRICE_PER_GAME));
    }
    return purchasingAmount / PRICE_PER_GAME;
  }


  private LottoGame createGameByRandomStrategy() {
    return new LottoGame(randomNumberGenerateStrategy.generateNewNumbers());
  }
}
