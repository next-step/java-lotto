package study.step2;

import study.step2.controller.LottoController;
import study.step2.domain.Lottos;
import study.step2.domain.ManualLottos;
import study.step2.domain.WinningLotto;
import study.step2.view.InputView;

public class LottoMain {

  public static void main(String[] args) {
    int money = InputView.inputMoney();

    int manualInputLottoCount = InputView.manualInputLottoCount(money);

    ManualLottos manualLottos = new ManualLottos(InputView.manualInputLottos(manualInputLottoCount));

    LottoController lottoController = new LottoController();
    Lottos lottos = lottoController.createLottos(money, manualLottos.getLottos().size());
    lottos.addManualLottos(manualLottos);

    WinningLotto winningLotto = new WinningLotto(InputView.inputLastLottoNumbers(), InputView.inputBonusNumber());

    lottoController.findLottoWinning(lottos, winningLotto, money);
  }

}
