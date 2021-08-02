package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.RealGenerateLottoNumber;

public class Lotties {

  List<Lotto> lotties = new ArrayList<>();

  GenerateLottoNumber generateLottoNumber = new RealGenerateLottoNumber(1,46);

  public Lotties() {
  }

  public Lotties(int count) {
    createLotties(count,generateLottoNumber);
  }

  public List<Lotto> getLotties() {
    return lotties;
  }

  public void createLotties(int count, GenerateLottoNumber generateLottoNumber) {
    for(int i = 0; i < count; i++){
      lotties.add(new Lotto(generateLottoNumber));
    }
  }
}
