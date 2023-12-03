package lotto.controller;

import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        Integer money = InputView.money();
        Integer manualNumber = InputView.manual();

        for (int i = 0; i < manualNumber; i++) {
            String manualLottoNumbers = InputView.manualLottoNumbers();
            Lottos lottos = new Lottos(manualLottoNumbers);
        }

        LottoSeller lottoSeller = new LottoSeller(money, manualNumber);
        ResultView.numberOfLotto(lottoSeller);
        Lottos lottos = new Lottos(lottoSeller.getNumberOfLotto());
        ResultView.printLottoList(lottos);


        String winningLottoNumber = InputView.winningLottoNumber();
        Integer bonusNumber = InputView.bonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningLottoNumber, bonusNumber);
        ResultView.winnerOfLottery(winningNumbers, lottos, lottoSeller);
    }
}
