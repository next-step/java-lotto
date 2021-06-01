package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void lotto() {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoResult lottoResult = new LottoResult();

        int money = inputView.money();
        while (!lottoMachine.validateMoney(money)) {
            System.out.println("금액을 천원 단위로 입력 하세요.");
            money = inputView.money();
        }

        List<LottoNumbers> lottoNumbers = lottoMachine.autoLottoNumbers(lottoMachine.buyCount(money));
        resultView.print(lottoNumbers);

        String numbers = inputView.numbers();
        LottoNumbers winningNumbers = new LottoNumbers(numbers);
        int bonusBall = inputView.bonusBall();
        LottoNumber bonusNumber = LottoNumber.valueOf(bonusBall);

        while (!lottoMachine.useAbleBonusBall(numbers, bonusNumber)) {
            System.out.println("보너스 볼은 당첨 번호와 달라야 합니다.");
            bonusNumber = LottoNumber.valueOf(inputView.bonusBall());
        }

        resultView.print();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        resultView.print(lottoResult.lottoResult(lottoNumbers, winningLotto), lottoResult.rateOfReturn(money));
    }

}
