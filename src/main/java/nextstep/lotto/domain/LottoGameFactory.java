package nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoGameFactory {

  private static final int GAME_COST = 1000;
  private final Supplier<Lotto> lottoGenerator;

  public LottoGameFactory(Supplier<Lotto> lottoGenerator) {
    this.lottoGenerator = lottoGenerator;
  }

  public List<Lotto> createAuto(int cost) {
    final int gameCount = cost / GAME_COST;
    final ArrayList<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < gameCount; i++) {
      lottos.add(lottoGenerator.get());
    }

    return lottos;
  }
}
