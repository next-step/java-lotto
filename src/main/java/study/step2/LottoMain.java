package study.step2;

import study.step2.controller.LottoController;
import study.step2.domain.Lotto;
import study.step2.domain.LottoNumber;
import study.step2.domain.Lottos;
import study.step2.view.InputView;

public class LottoMain {

  public static void main(String[] args) {
    int money = InputView.inputMoney();

    LottoController lottoController = new LottoController();
    Lottos lottos = lottoController.createLottos(money);

    LottoNumber lottoNumber = new LottoNumber(InputView.inputLastLottoNumbers());

    Lotto winningLotto = new Lotto(lottoNumber);
    lottoController.findLottoWinning(lottos, winningLotto, money);
  }

}
