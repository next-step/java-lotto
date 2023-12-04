package lotto.controller;

import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        Integer money = InputView.money();
        int manualNumber = InputView.manual();
        Lottos lottos = new Lottos();

        for (int i = 0; i < manualNumber; i++) {
            String manualLottoNumbers = InputView.manualLottoNumbers();
            lottos.manualLotto(manualLottoNumbers);
        }

        LottoSeller lottoSeller = new LottoSeller(money, manualNumber);
        ResultView.numberOfLotto(lottoSeller);
        lottos.autoLotto(lottoSeller.getNumberOfAuto());
        ResultView.printLottoList(lottos);


        String winningLottoNumber = InputView.winningLottoNumber();
        Integer bonusNumber = InputView.bonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningLottoNumber, bonusNumber);
        ResultView.winnerOfLottery(winningNumbers, lottos, lottoSeller);
    }
}
