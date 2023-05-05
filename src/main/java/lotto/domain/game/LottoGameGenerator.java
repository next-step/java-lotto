package lotto.domain.game;

import java.util.Collections;
import java.util.List;
import util.CollectionUtils;

public class LottoGameGenerator {

  private final LottoGameSetting gameSetting;
  private final LottoPurchasePrice purchasePrice;
  private final List<List<Integer>> manualLottoRounds;

  public LottoGameGenerator (int lottoPrice, List<List<Integer>> manualLottoRounds, LottoGameSetting gameSetting) {
    this.purchasePrice = new LottoPurchasePrice(gameSetting.getPricePerGame(), lottoPrice);
    this.manualLottoRounds = manualLottoRounds;
    this.gameSetting = gameSetting;
  }

  public LottoGameGenerator (int lottoPrice, LottoGameSetting gameSetting) {
    this.purchasePrice = new LottoPurchasePrice(gameSetting.getPricePerGame(), lottoPrice);
    this.manualLottoRounds = Collections.emptyList();
    this.gameSetting = gameSetting;
  }

  public LottoGameWrapper generateLottoGame() {
    if (CollectionUtils.isNullOrEmpty(manualLottoRounds)) {
      return new LottoGameWrapper(LottoGame.ofAutoOnly(purchasePrice, gameSetting), List.of(LottoGameType.AUTO));
    }

    if (purchasePrice.getGameCount() == manualLottoRounds.size()) {
      return new LottoGameWrapper(LottoGame.ofManualOnly(manualLottoRounds, purchasePrice, gameSetting), List.of(LottoGameType.MANUAL));
    }

    return new LottoGameWrapper(LottoGame.ofAutoManualMixed(manualLottoRounds, purchasePrice, gameSetting), List.of(LottoGameType.AUTO, LottoGameType.MANUAL));
  }
}
