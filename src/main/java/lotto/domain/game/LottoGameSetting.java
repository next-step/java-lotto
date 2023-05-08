package lotto.domain.game;

import lotto.domain.raffle.BaseKoreaLottoRaffleGenerator;
import lotto.domain.raffle.LottoRaffleGenerator;
import lotto.domain.round.LottoRoundJudge;

public class LottoGameSetting {
  private final LottoRaffleGenerator raffleGenerator;
  private final LottoRoundJudge roundJudge;
  private final boolean distinctNumberOnly;
  private final LottoPricePerGame pricePerGame;

  private LottoGameSetting(LottoRaffleGenerator raffleGenerator, LottoRoundJudge roundJudge, boolean distinctNumberOnly, LottoPricePerGame pricePerGame) {
    this.raffleGenerator = raffleGenerator;
    this.roundJudge = roundJudge;
    this.distinctNumberOnly = distinctNumberOnly;
    this.pricePerGame = pricePerGame;
  }

  public static LottoGameSettingBuilder builder() {
    return new LottoGameSettingBuilder();
  }

  public static LottoGameSetting ofKorea645LottoSetting() {
    return builder()
        .raffleGenerator(new BaseKoreaLottoRaffleGenerator())
        .roundJudge(new LottoRoundJudge())
        .distinctNumberOnly(true)
        .pricePerGame(1000)
        .build();
  }

  public LottoRaffleGenerator getRaffleGenerator() {
    return raffleGenerator;
  }

  public LottoRoundJudge getRoundJudge() {
    return roundJudge;
  }

  public boolean isDistinctNumberOnly() {
    return distinctNumberOnly;
  }

  public LottoPricePerGame getPricePerGame() {
    return pricePerGame;
  }

  public static class LottoGameSettingBuilder {

    private LottoRaffleGenerator raffleGenerator;
    private Boolean distinctNumberOnly;
    private LottoPricePerGame pricePerGame;
    private LottoRoundJudge roundJudge;

    public LottoGameSettingBuilder raffleGenerator (LottoRaffleGenerator raffleGenerator) {
      this.raffleGenerator = raffleGenerator;
      return this;
    }

    public LottoGameSettingBuilder distinctNumberOnly(boolean distinctNumberOnly) {
      this.distinctNumberOnly = distinctNumberOnly;
      return this;
    }

    public LottoGameSettingBuilder pricePerGame (int pricePerGame) {
      this.pricePerGame = new LottoPricePerGame(pricePerGame);
      return this;
    }

    public LottoGameSettingBuilder roundJudge (LottoRoundJudge lottoRoundJudge) {
      this.roundJudge = lottoRoundJudge;
      return this;
    }

    public boolean getOrDefaultDistinctNumberOnly() {
      if (this.distinctNumberOnly != null) {
        return this.distinctNumberOnly;
      }
      return true;
    }

    public LottoRoundJudge getOrDefaultRoundJudge() {
      if (this.roundJudge != null) {
        return this.roundJudge;
      }
      return new LottoRoundJudge();
    }

    public LottoGameSetting build () {
      boolean distinctNumberOnly = getOrDefaultDistinctNumberOnly();
      LottoRoundJudge roundJudge = getOrDefaultRoundJudge();

      return new LottoGameSetting(this.raffleGenerator, roundJudge, distinctNumberOnly, this.pricePerGame);
    }
  }
}
