package lotto.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundJudge;
import lotto.domain.round.LottoRoundNumbers;
import lotto.domain.round.LottoRoundResult;

public class LottoGame {

  private final LottoPurchasePrice purchasePrice;
  private final LottoRaffleGenerator raffleGenerator;
  private final List<LottoRound> lottoRounds;
  private final LottoRoundJudge roundJudge;
  private final boolean distinctNumberOnly;

  private LottoGame (LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    this.raffleGenerator = gameSetting.getRaffleGenerator();
    this.distinctNumberOnly = gameSetting.isDistinctNumberOnly();
    this.purchasePrice = purchasePrice;
    this.roundJudge = new LottoRoundJudge();
    this.lottoRounds = initAutoOnlyRounds();
    throwIfRoundSizeNotMatch(this.purchasePrice.getGameCount(), this.lottoRounds);
  }

  private LottoGame (List<List<Integer>> manualRounds, LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    this.raffleGenerator = gameSetting.getRaffleGenerator();
    this.distinctNumberOnly = gameSetting.isDistinctNumberOnly();
    this.purchasePrice = purchasePrice;
    this.roundJudge = new LottoRoundJudge();
    this.lottoRounds = initManualIncludeLottoRounds(manualRounds);
    throwIfRoundSizeNotMatch(this.purchasePrice.getGameCount(), this.lottoRounds);
  }

  public static LottoGame ofAutoOnly (LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    return new LottoGame(purchasePrice, gameSetting);
  }

  public static LottoGame ofAutoManualMixed (List<List<Integer>> manualRounds, LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    return new LottoGame(manualRounds, purchasePrice, gameSetting);
  }

  public static LottoGame ofManualOnly(List<List<Integer>> manualRounds, LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    return new LottoGame(manualRounds, purchasePrice, gameSetting);
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

  private List<LottoRound> initAutoOnlyRounds() {
    return IntStream.rangeClosed(1, this.purchasePrice.getGameCount())
        .mapToObj(i -> new LottoRound(new LottoRoundNumbers(raffleGenerator.generateRaffleNumber()), roundJudge))
        .collect(Collectors.toList());
  }

  private List<LottoRound> initManualIncludeLottoRounds(List<List<Integer>> manualRoundNumbers) {
    int gameCount = purchasePrice.getGameCount();
    List<LottoRound> manualRounds = makeManualLottoRounds(manualRoundNumbers);
    List<LottoRound> autoRounds = IntStream.rangeClosed(manualRounds.size() + 1, gameCount)
        .mapToObj(i -> new LottoRound(new LottoRoundNumbers(raffleGenerator.generateRaffleNumber()), roundJudge))
        .collect(Collectors.toList());

    List<LottoRound> rounds = new ArrayList<>(gameCount);
    rounds.addAll(manualRounds);
    rounds.addAll(autoRounds);
    return rounds;
  }

  private List<LottoRound> makeManualLottoRounds(List<List<Integer>> manualRounds) {
    return IntStream.rangeClosed(1, manualRounds.size())
        .mapToObj(i -> new LottoRound(new LottoRoundNumbers(manualRounds.get(i - 1)), roundJudge))
        .collect(Collectors.toList());
  }

  private void throwIfRoundSizeNotMatch(int gameCount, List<LottoRound> lottoRounds) {
    if(gameCount != lottoRounds.size()) {
      throw new IllegalArgumentException("구입 금액과 그에 맞는 로또 게임 수가 일치하지 않습니다. 금액을 다시 확인해주세요");
    }
  }
}
