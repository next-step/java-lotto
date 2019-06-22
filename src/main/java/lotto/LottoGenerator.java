package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  private static final int price = 1000;
  private final NumberGenerator numberGenerator;

  public LottoGenerator(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public List<Lotto> generate(int paid) {
    int amount = paid / price;
    return IntStream.range(0, amount)
            .mapToObj((int value) -> new Lotto(numberGenerator.generate(6)))
            .collect(Collectors.toList());
  }
}
