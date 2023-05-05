package lotto.domain.game;

import java.util.List;
import util.CollectionUtils;

public class LottoGameGenerator {

  private final LottoGameSetting gameSetting;
  private final int lottoPrice;
  private final List<List<Integer>> manualLottoRounds;

  public LottoGameGenerator (int lottoPrice, List<List<Integer>> manualLottoRounds, LottoGameSetting gameSetting) {
    this.lottoPrice = lottoPrice;
    this.manualLottoRounds = manualLottoRounds;
    this.gameSetting = gameSetting;
  }

  public LottoGame initLottoGame () {
    if (CollectionUtils.isNullOrEmpty(manualLottoRounds)) {
      return LottoGame.ofAutoOnly(lottoPrice, gameSetting);
    }

    return LottoGame.ofAutoManualMixed(manualLottoRounds, lottoPrice, gameSetting);
  }
}
