package nextstep.lotto;

import java.util.function.Supplier;

public class LottoGameFactory {

  private final Supplier<Lotto> lottoGenerator;

  public LottoGameFactory(Supplier<Lotto> lottoGenerator) {
    this.lottoGenerator = lottoGenerator;
  }

  public Lotto random() {
    return lottoGenerator.get();
  }
}
