package study.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottosFactory {

  public static Lottos makeLottos(int lottoCount) {
    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < lottoCount; i++) {
      List<Integer> pickedLottoNumbers = LottoNumbers.pick();
      Lotto lotto = new Lotto(pickedLottoNumbers);
      lottoList.add(lotto);
    }

    return new Lottos(lottoList);
  }



}
