package study.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottosFactory {

  public static Lottos makeLottos(int lottoCount) {
    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < lottoCount; i++) {
      Set<LottoNumber> pickedLottoNumbers = LottoMachine.pick();

      Lotto lotto = new Lotto(pickedLottoNumbers);
      lottoList.add(lotto);
    }

    return new Lottos(lottoList);
  }

}
