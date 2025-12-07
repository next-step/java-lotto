package lotto;

import java.util.ArrayList;
import java.util.List;

public class AutoLottosGenerator implements LottosGenerator {

  private final int count;

  public AutoLottosGenerator(int count) {
    this.count = count;
  }

  @Override
  public Lottos generate() {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      lottos.add(LottoMachine.randomLotto());
    }
    return new Lottos(lottos);
  }

}
