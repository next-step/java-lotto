package lotto.domain.round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.game.LottoGameSetting;
import lotto.domain.game.LottoPurchasePrice;
import lotto.domain.raffle.LottoRaffleGenerator;
import util.CollectionUtils;

public class LottoRoundGenerator {
  private final LottoPurchasePrice purchasePrice;
  private final List<List<Integer>> manualLottoRounds;
  private final LottoRaffleGenerator raffleGenerator;
  private final LottoRoundJudge roundJudge;

  public LottoRoundGenerator (List<List<Integer>> manualLottoRounds, LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    this.purchasePrice = purchasePrice;
    this.manualLottoRounds = manualLottoRounds;
    this.raffleGenerator = gameSetting.getRaffleGenerator();
    this.roundJudge = gameSetting.getRoundJudge();
  }

  public LottoRoundGenerator (LottoPurchasePrice purchasePrice, LottoGameSetting gameSetting) {
    this.purchasePrice = purchasePrice;
    this.manualLottoRounds = Collections.emptyList();
    this.raffleGenerator = gameSetting.getRaffleGenerator();
    this.roundJudge = gameSetting.getRoundJudge();
  }

  public List<LottoRound> generateRounds() {
    if (CollectionUtils.isNullOrEmpty(this.manualLottoRounds)) {
      return initAutoOnlyRounds();
    }

    return initManualIncludeLottoRounds(this.manualLottoRounds);
  }

  private List<LottoRound> initAutoOnlyRounds() {
    return IntStream.rangeClosed(1, this.purchasePrice.getGameCount())
        .mapToObj(i -> new LottoRound(raffleGenerator.generateRaffleNumber(), roundJudge))
        .collect(Collectors.toList());
  }

  private List<LottoRound> initManualIncludeLottoRounds(List<List<Integer>> manualRoundNumbers) {
    int gameCount = purchasePrice.getGameCount();
    List<LottoRound> manualRounds = makeManualLottoRounds(manualRoundNumbers);
    List<LottoRound> autoRounds = IntStream.rangeClosed(manualRounds.size() + 1, gameCount)
        .mapToObj(i -> new LottoRound(raffleGenerator.generateRaffleNumber(), roundJudge))
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
}
