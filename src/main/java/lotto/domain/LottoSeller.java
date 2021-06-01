package lotto.domain;

import lotto.input.PurchaseAmountQuantity;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoSeller {

  private final NumberGenerator numberGenerator;

  public LottoSeller(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public LottoBucket getLottoBucketBy(PurchaseAmountQuantity purchaseAmountQuantity) {
    ArrayList<Lotto> lottos = getManualLottosFrom(purchaseAmountQuantity);
    addAutoLottos(purchaseAmountQuantity, lottos);

    return new LottoBucket(lottos);
  }

  private ArrayList<Lotto> getManualLottosFrom(PurchaseAmountQuantity purchaseAmountQuantity) {
    return purchaseAmountQuantity
        .getManualLottoNumbers()
        .stream()
        .map(Lotto::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private void addAutoLottos(PurchaseAmountQuantity purchaseAmountQuantity, ArrayList<Lotto> lottos) {
    IntStream
        .range(0, purchaseAmountQuantity.getAutoCount())
        .mapToObj(quantity -> new Lotto(numberGenerator))
        .forEach(lottos::add);
  }
}
