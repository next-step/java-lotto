package study.step2;

import static study.step2.Exception.CustomException.LOTTO_NUMBER_DUPLICATED_EXCEPTION;
import static study.step2.validator.Validator.NUMBER_OF_LOTTO_NUMBER;

import study.step2.controller.LottoController;
import study.step2.domain.LottoNumber;
import study.step2.domain.Lottos;
import study.step2.domain.WinningLotto;
import study.step2.view.InputView;

public class LottoMain {

  public static void main(String[] args) {
    int money = InputView.inputMoney();

    LottoController lottoController = new LottoController();
    Lottos lottos = lottoController.createLottos(money);

    WinningLotto winningLotto = new WinningLotto(InputView.inputLastLottoNumbers());
    winningLotto.validatorPositiveNumbers();
    winningLotto.checkDuplication();

    LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

    lottoController.findLottoWinning(lottos, winningLotto, money, bonusNumber);
  }

}
