package lotto.domain;

import lotto.input.PurchaseAmountQuantity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class LottoSeller {

  public LottoBucket getLottoBucketBy(PurchaseAmountQuantity purchaseAmountQuantity) {
    List<Lotto> manualLottos = getManualLottosFrom(purchaseAmountQuantity);
    List<Lotto> autoLottos = getAutoLottosFrom(purchaseAmountQuantity);

    return new LottoBucket(
        Stream
            .concat(manualLottos.stream(), autoLottos.stream())
            .collect(Collectors.toList())
    );
  }

  private List<Lotto> getManualLottosFrom(PurchaseAmountQuantity purchaseAmountQuantity) {
    return purchaseAmountQuantity
        .getManualLottoNumbers()
        .stream()
        .map(inputManualNumber -> new Lotto(new ManualNumberGenerator(inputManualNumber)))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private List<Lotto> getAutoLottosFrom(PurchaseAmountQuantity purchaseAmountQuantity) {
    return IntStream
        .range(0, purchaseAmountQuantity.getAutoCount())
        .mapToObj(quantity -> new Lotto(new RandomNumberGenerator(new Random())))
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
