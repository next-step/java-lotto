package study.step2.domain;

import java.util.List;

public class LottosFactory {

  public static Lottos makeLottos(int lottoCount) {
    Lottos lottos = new Lottos();

    for (int i = 0; i < lottoCount; i++) {
      List<Integer> pickedLottoNumbers = LottoNumbers.pick();
      Lotto lotto = new Lotto(pickedLottoNumbers);
      lottos.add(lotto);
    }

    return lottos;
  }

}
