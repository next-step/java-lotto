package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {

  private final NumberGenerator numberGenerator;
  private static final int QUANTITY_OF_THE_NUMBER_TO_GENERATE = 6;

  public LottoGenerator(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public Lottos generate(Money paid) {
    int quantity = paid.getPurchaseableQuantity();
    List<Lotto> lottos = IntStream.range(0, quantity)
            .mapToObj((int value) -> new Lotto(numberGenerator.generate(QUANTITY_OF_THE_NUMBER_TO_GENERATE)))
            .collect(toList());

    return new Lottos(lottos);
  }

  public static Lotto generate(List<LottoNumber> numbers) {
    return new Lotto(numbers);
  }

  public static Lottos generateManually(List<Lotto> lottos) {
    return new Lottos(lottos);
  }

  public static Lottos union(Lottos lottos1, Lottos lottos2) {
    List<Lotto> unionLottos = new ArrayList<>();
    unionLottos.addAll(lottos1.getLottos());
    unionLottos.addAll(lottos2.getLottos());
    return new Lottos(unionLottos);
  }
}
