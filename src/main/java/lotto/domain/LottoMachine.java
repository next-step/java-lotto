package lotto.domain;

import lotto.dto.AnalysisSheet;
import lotto.dto.OrderSheet;
import lotto.dto.TotalOrderedLottoGameNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoMachine {

  private static final int PRICE_PER_GAME = 1000;
  private static final String INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME = "최소 구입 금액은 %d원 이상입니다.";

  private final OrderSheet orderSheet;
  private final LottoGames orderedGames;

  public LottoMachine(OrderSheet orderSheet) {
    this.orderSheet = orderSheet;
    this.orderedGames = generateNewOrderedAutoGames(orderSheet.getPurchasingAmount());
  }

  //For Test Code
  private LottoMachine(OrderSheet orderSheet, LottoGames lottoGames) {
    this.orderSheet = orderSheet;
    this.orderedGames = lottoGames;
  }

  //For Test Code
  static LottoMachine staticFactoryMethodForTestCode(long testPurchasingAmount, List<LottoGame> testGames) {
    return new LottoMachine(new OrderSheet(testPurchasingAmount), new LottoGames(testGames));
  }

  public TotalOrderedLottoGameNumbers peekOrderedGames() {
    return orderedGames.peekGameInfos();
  }

  public AnalysisSheet confirmPrizeOrderedLottos(List<Integer> inputWinningNumbers) {
    LottoGame winningGame = createLottoGame(inputWinningNumbers);
    TotalRankings totalRankings = orderedGames.matchRankings(winningGame);
    return new AnalysisSheet(totalRankings, orderSheet.getPurchasingAmount());
  }

  private LottoGames generateNewOrderedAutoGames(long purchasingAmount) {
    List<LottoGame> lottGames = LongStream.range(0, computeNumberOfGames(purchasingAmount))
        .mapToObj(longValue -> new LottoGame(LottoNumbersFactory.generateNewNumbers()))
        .collect(Collectors.toList());
    return new LottoGames(lottGames);
  }

  private long computeNumberOfGames(long purchasingAmount) {
    if (purchasingAmount < PRICE_PER_GAME) {
      throw new IllegalArgumentException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, PRICE_PER_GAME));
    }
    return purchasingAmount / PRICE_PER_GAME;
  }

  private LottoGame createLottoGame(List<Integer> inputNumbers) {
    List<LottoNumber> lottoNumbers = inputNumbers.stream()
                                    .map(LottoNumber::new)
                                    .collect(Collectors.toList());
    return new LottoGame(new LottoNumbers(lottoNumbers));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoMachine that = (LottoMachine) o;
    return orderSheet.equals(that.orderSheet) && orderedGames.equals(that.orderedGames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderSheet, orderedGames);
  }
}
