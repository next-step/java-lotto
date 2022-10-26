package domain.lotto;

import domain.strategy.GenerateLottoNum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

  public List<Lotto> lottos = new ArrayList<>();
  private final int LOTTOSIZE = 6;

  public Lottos(int amount, GenerateLottoNum generateLottoNum) {
    this.lottos = putLottos(amount, generateLottoNum);
  }

  private List<Lotto> putLottos(int amount, GenerateLottoNum generateLottoNum) {
    for (int i = 0; i < amount; i++) {
      Lotto lotto = new Lotto(generateLottoNum.generate());
      this.lottos.add(lotto);
    }
    return lottos;
  }

}
