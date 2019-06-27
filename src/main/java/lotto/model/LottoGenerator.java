package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            .collect(Collectors.toList());

    return new Lottos(lottos);
  }

  public static Lotto generate(List<Integer> numbers) {
    return new Lotto(numbers);
  }
}
