package lotto.input;

import lotto.domain.MatchNumberCount;
import lotto.domain.LottoRoi;
import lotto.domain.MessagePrinter;

import java.util.List;

public final class PurchaseAmountQuantity {

  private final int amount;
  private final int quantity;
  private final int manualCount;
  private final int autoCount;
  private final List<String> manualLottoNumbers;

  public PurchaseAmountQuantity(int amount, int manualCount, List<String> manualLottoNumbers) {
    this.amount = amount;
    this.quantity = amount / 1000;
    this.manualCount = manualCount;
    this.autoCount = quantity - manualCount;
    this.manualLottoNumbers = manualLottoNumbers;

    MessagePrinter.print("\n수동으로 " + this.manualCount + "장, 자동으로 " + this.autoCount + "개를 구매했습니다.");
  }

  public LottoRoi getRoiBy(MatchNumberCount matchNumberCount) {
    return new LottoRoi(
        Math.floor((double) matchNumberCount.getRevenue() / this.amount * 100) / 100.0
    );
  }

  public List<String> getManualLottoNumbers() {
    return manualLottoNumbers;
  }

  public int getAutoCount() {
    return autoCount;
  }
}
