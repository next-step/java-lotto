package lotto.domain.game;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRoundJudge;
import lotto.domain.round.LottoRoundResult;
import lotto.domain.round.LottoRound;

public class LottoGame {

  private static final int PRICE_PER_GAME = 1000;

  private final int purchasePrice;
  private final LottoRaffleGenerator raffleGenerator;
  private final List<LottoRound> lottoRounds;
  private final LottoRoundJudge roundJudge;


  public LottoGame (int purchasePrice, LottoRaffleGenerator raffleGenerator) {
    final int gameCount = getLottoGameCount(purchasePrice);
    this.purchasePrice = purchasePrice;
    this.raffleGenerator = raffleGenerator;
    this.roundJudge = new LottoRoundJudge();
    this.lottoRounds = initLottoRounds(gameCount);
  }

  public LottoGameStatistics play (final Set<Integer> winningNumbers) {
    final List<LottoRoundResult> roundStatistics = lottoRounds.stream()
        .map(purchaseLotto -> purchaseLotto.playRound(winningNumbers))
        .collect(Collectors.toList());
    return new LottoGameStatistics(purchasePrice, roundStatistics);
  }

  public List<LottoRound> getLottoRounds() {
    return lottoRounds;
  }

  private List<LottoRound> initLottoRounds (int gameCount) {
    return IntStream.rangeClosed(1, gameCount)
        .mapToObj(i -> new LottoRound(i, raffleGenerator.generateRaffleNumber(), roundJudge))
        .collect(Collectors.toList());
  }

  private int getLottoGameCount(int purchasePrice) {
    if (purchasePrice % PRICE_PER_GAME > 0) {
      throw new IllegalArgumentException();
    }
    return purchasePrice / PRICE_PER_GAME;
  }
}
