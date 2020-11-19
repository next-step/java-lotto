package lotto.domain;

import lotto.domain.model.LottoGames;
import lotto.exception.LottoGameException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.config.LottoGameConfig.PRICE_PER_GAME;
import static lotto.constants.Message.INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME;

public class PurchaseAction {

  private static final int ZERO = 0;

  private final int purchasePrice;
  private final List<String[]> manualLottoNumbers;
  private final int autoLottoGameCount;

  //for test
  public PurchaseAction(int purchasePrice, List<String[]> manualLottoNumbers, int autoLottoGameCount) {
    this.purchasePrice = purchasePrice;
    this.manualLottoNumbers = manualLottoNumbers;
    this.autoLottoGameCount = autoLottoGameCount;
  }

  public PurchaseAction(int purchasePrice, List<String[]> manualLottoNumbers) {
    this.purchasePrice = purchasePrice;
    this.manualLottoNumbers = manualLottoNumbers;
    this.autoLottoGameCount = computeautoLottoGameCount();
  }

  private int computeautoLottoGameCount() {
    if (purchasePrice < PRICE_PER_GAME) {
      throw new LottoGameException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, PRICE_PER_GAME));
    }
    return (purchasePrice / PRICE_PER_GAME) - manualLottoNumbers.size();
  }

  public int getPurchasePrice() {
    return purchasePrice;
  }

  public int manualLottoGameCount() {
    return manualLottoNumbers.size();
  }

  public int autoLottoGameCount() {
    return autoLottoGameCount;
  }

  public LottoGames purchase() {
    List<Lotto> lottoGames = purchaseManualLottoGames();
    lottoGames.addAll(purchaseAutoLottoGames());
    return new LottoGames(lottoGames);
  }

  private List<Lotto> purchaseManualLottoGames() {
    return manualLottoNumbers.stream()
        .map(LottoGameManager::newManualLotto)
        .collect(Collectors.toList());
  }

  private List<Lotto> purchaseAutoLottoGames() {
    return IntStream.range(ZERO, autoLottoGameCount)
        .mapToObj(index -> LottoGameManager.newAutoLotto())
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseAction that = (PurchaseAction) o;
    return purchasePrice == that.purchasePrice &&
        autoLottoGameCount == that.autoLottoGameCount &&
        Objects.equals(manualLottoNumbers, that.manualLottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasePrice, manualLottoNumbers, autoLottoGameCount);
  }
}
