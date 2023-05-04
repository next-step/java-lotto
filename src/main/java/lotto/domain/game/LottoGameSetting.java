package lotto.domain.game;

import lotto.domain.raffle.LottoRaffleGenerator;

public class LottoGameSetting {
  private final LottoRaffleGenerator raffleGenerator;
  private final boolean distinctNumberOnly;
  private final LottoPricePerGame pricePerGame;

  private LottoGameSetting(LottoRaffleGenerator raffleGenerator, boolean distinctNumberOnly, LottoPricePerGame pricePerGame) {
    this.raffleGenerator = raffleGenerator;
    this.distinctNumberOnly = distinctNumberOnly;
    this.pricePerGame = pricePerGame;
  }

  public static LottoGameSettingBuilder builder() {
    return new LottoGameSettingBuilder();
  }

  public LottoRaffleGenerator getRaffleGenerator() {
    return raffleGenerator;
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

    public LottoGameSetting build () {
      boolean distinctNumberOnly = this.distinctNumberOnly != null ? this.distinctNumberOnly : true;
      return new LottoGameSetting(this.raffleGenerator, distinctNumberOnly, this.pricePerGame);
    }
  }
}
