package lotto.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundGenerator;
import lotto.domain.round.LottoRoundResult;

public class LottoGame {

  private final LottoPurchasePrice purchasePrice;
  private final LottoRoundGenerator roundGenerator;
  private final List<LottoRound> lottoRounds;
  private final boolean distinctNumberOnly;

  public LottoGame (int purchasePrice, LottoGameSetting gameSetting) {
    this.purchasePrice = new LottoPurchasePrice(gameSetting, purchasePrice);
    this.roundGenerator = new LottoRoundGenerator(this.purchasePrice, gameSetting);
    this.distinctNumberOnly = gameSetting.isDistinctNumberOnly();
    this.lottoRounds = this.roundGenerator.generateRounds();
    throwIfRoundSizeNotMatch(this.purchasePrice.getGameCount(), this.lottoRounds);
  }

  public LottoGame (List<List<Integer>> manualRounds, int purchasePrice, LottoGameSetting gameSetting) {
    this.purchasePrice = new LottoPurchasePrice(gameSetting, purchasePrice);;
    this.roundGenerator = new LottoRoundGenerator(manualRounds,this.purchasePrice, gameSetting);
    this.distinctNumberOnly = gameSetting.isDistinctNumberOnly();
    this.lottoRounds = this.roundGenerator.generateRounds();
    throwIfRoundSizeNotMatch(this.purchasePrice.getGameCount(), this.lottoRounds);
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

  private void throwIfRoundSizeNotMatch(int gameCount, List<LottoRound> lottoRounds) {
    if(gameCount != lottoRounds.size()) {
      throw new IllegalArgumentException("구입 금액과 그에 맞는 로또 게임 수가 일치하지 않습니다. 금액을 다시 확인해주세요");
    }
  }
}
