package study.step2.domain;

import java.util.Set;

public class LottosFactory {

  public static Lottos makeLottos(int lottoCount) {
    Lottos lottos = new Lottos();

    for (int i = 0; i < lottoCount; i++) {
      Set<Integer> pickedLottoNumbers = LottoMachine.pick();
      Lotto lotto = new Lotto(pickedLottoNumbers);
      lottos.add(lotto);
    }

    return lottos;
  }

}
