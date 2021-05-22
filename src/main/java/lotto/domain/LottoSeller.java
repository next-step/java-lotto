package lotto.domain;

import lotto.input.PurchaseAmountQuantity;

import java.util.ArrayList;

public final class LottoSeller {

  private final NumberGenerator numberGenerator;

  public LottoSeller(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public LottoBucket getLottoBucketBy(PurchaseAmountQuantity purchaseAmountQuantity) {
    ArrayList<Lotto> lottos = new ArrayList<>();
    for (int quantity = 0; quantity < purchaseAmountQuantity.getQuantity(); quantity++) {
      lottos.add(new Lotto(numberGenerator));
    }

    return new LottoBucket(lottos);
  }
}
