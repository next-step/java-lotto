package study.step2.domain;

import study.step2.view.InputView;

public class LottosFactory {

  public static Lottos makeLottos(int lottoCount) {
    Lottos lottos = new Lottos();

    for (int i = 0; i < lottoCount; i++) {
      LottoNumber pickedLottoNumbers = new LottoNumber(LottoMachine.pick());

      Lotto lotto = new Lotto(pickedLottoNumbers);
      lottos.add(lotto);
    }

    return lottos;
  }

}
