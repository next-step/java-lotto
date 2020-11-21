package lotto.domain.model;

import static lotto.config.LottoGameConfig.PRICE_PER_GAME;
import static lotto.constants.Message.INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME;

import java.util.List;
import java.util.Objects;
import lotto.exception.LottoGameException;

public class LottoSupplier {
  private final Lotteries manualLotteries;
  private final int autoLottoGameCount;

  public LottoSupplier(List<String[]> manualLottoNumbers, int purchasePrice) {
    this.manualLotteries = new Lotteries(manualLottoNumbers);
    this.autoLottoGameCount = computeAutoLottoGameCount(purchasePrice);
  }

  private int computeAutoLottoGameCount(int purchasePrice) {
    if (purchasePrice < PRICE_PER_GAME) {
      throw new LottoGameException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, PRICE_PER_GAME));
    }
    return (purchasePrice / PRICE_PER_GAME) - manualLotteries.size();
  }

  public Lotteries manualLottoNumbers() {
    return manualLotteries;
  }

  public int autoLottoGameCount() {
    return autoLottoGameCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoSupplier that = (LottoSupplier) o;
    return autoLottoGameCount == that.autoLottoGameCount &&
        Objects.equals(manualLotteries, that.manualLotteries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manualLotteries, autoLottoGameCount);
  }
}
