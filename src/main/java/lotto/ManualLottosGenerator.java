package lotto;

import java.util.List;

public class ManualLottosGenerator implements LottosGenerator {

  private final List<String> manualNumbers;

  public ManualLottosGenerator(List<String> manualNumbers) {
    this.manualNumbers = manualNumbers;
  }

  @Override
  public Lottos generate() {
    return new Lottos(manualNumbers.stream().map(Lotto::new).toList());
  }
}
