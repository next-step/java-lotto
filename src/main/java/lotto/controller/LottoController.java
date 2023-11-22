package lotto.controller;

import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        String money = InputView.money();

        LottoSeller lottoSeller = new LottoSeller(money);
        ResultView.numberOfLotto(lottoSeller);
        Lottos lottos = new Lottos(lottoSeller.getNumberOfLotto());
        ResultView.printLottoList(lottos);

        List<Integer> winningLottoNumber = InputView.winningLottoNumber();
        Integer bonusNumber = InputView.bonusNumber();
        winningLottoNumber.add(bonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winningLottoNumber);
        ResultView.winnerOfLottery(winningNumbers, lottos, lottoSeller);
    }
}
