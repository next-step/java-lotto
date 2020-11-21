package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoGames;
import lotto.domain.model.LottoSupplier;

public class PurchaseAction {

  private static final int ZERO = 0;

  private final int purchasePrice;
  private LottoSupplier lottoSupplier;

  public PurchaseAction(int purchasePrice, List<String[]> manualLottoNumbers) {
    this.purchasePrice = purchasePrice;
    this.lottoSupplier = new LottoSupplier(manualLottoNumbers, purchasePrice);
  }

  public int getPurchasePrice() {
    return purchasePrice;
  }

  public int manualLottoGameCount() {
    return lottoSupplier.manualLottoNumbers().size();
  }

  public int autoLottoGameCount() {
    return lottoSupplier.autoLottoGameCount();
  }

  public LottoGames purchase() {
    List<Lotto> lottoGames = purchaseManualLottoGames();
    lottoGames.addAll(purchaseAutoLottoGames());
    return new LottoGames(lottoGames);
  }

  private List<Lotto> purchaseManualLottoGames() {
    return lottoSupplier.manualLottoNumbers().getLottoNumbers();
  }

  private List<Lotto> purchaseAutoLottoGames() {
    return IntStream.range(ZERO, lottoSupplier.autoLottoGameCount())
        .mapToObj(index -> LottoGameManager.newAutoLotto())
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PurchaseAction that = (PurchaseAction) o;
    return purchasePrice == that.purchasePrice &&
        Objects.equals(lottoSupplier, that.lottoSupplier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasePrice, lottoSupplier);
  }
}
