package lotto.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundJudge;
import lotto.domain.round.LottoRoundNumbers;
import lotto.domain.round.LottoRoundResult;

public class LottoGame {

  private static final int PRICE_PER_GAME = 1000;

  private final LottoPurchasePrice purchasePrice;
  private final LottoRaffleGenerator raffleGenerator;
  private final List<LottoRound> lottoRounds;
  private final LottoRoundJudge roundJudge;
  private final boolean distinctNumberOnly;

  public LottoGame (int purchasePrice, LottoRaffleGenerator raffleGenerator) {
    this.purchasePrice = new LottoPurchasePrice(PRICE_PER_GAME, purchasePrice);
    this.raffleGenerator = raffleGenerator;
    this.roundJudge = new LottoRoundJudge();
    this.distinctNumberOnly = true;
    this.lottoRounds = initLottoRounds();
  }

  public LottoGame (int purchasePrice, LottoRaffleGenerator raffleGenerator, boolean distinctNumberOnly) {
    this.purchasePrice = new LottoPurchasePrice(PRICE_PER_GAME, purchasePrice);
    this.raffleGenerator = raffleGenerator;
    this.roundJudge = new LottoRoundJudge();
    this.distinctNumberOnly = distinctNumberOnly;
    this.lottoRounds = initLottoRounds();
  }

  public LottoGameStatistics play (final LottoWinningNumber winningNumber) {
    throwIfAgainstDistinctPolicy(winningNumber);
    final List<LottoRoundResult> roundStatistics = lottoRounds.stream()
        .map(purchaseLotto -> purchaseLotto.playRound(winningNumber))
        .collect(Collectors.toList());

    return new LottoGameStatistics(this.purchasePrice, roundStatistics);
  }

  private void throwIfAgainstDistinctPolicy(final LottoWinningNumber winningNumber) {
    if (distinctNumberOnly && winningNumber.containsDuplicateNumber()) {
      throw new IllegalArgumentException("당첨번호가 중복일 수 없습니다.");
    }
  }

  public List<LottoRound> getLottoRounds () {
    return lottoRounds;
  }

  private List<LottoRound> initLottoRounds () {
    return IntStream.rangeClosed(1, this.purchasePrice.getGameCount())
        .mapToObj(i -> new LottoRound(i, new LottoRoundNumbers(raffleGenerator.generateRaffleNumber()), roundJudge))
        .collect(Collectors.toList());
  }
}
