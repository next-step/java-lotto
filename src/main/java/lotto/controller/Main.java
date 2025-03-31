package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int money = InputView.getMoney();
        List<String> manuelLottoNumbers = InputView.getManuelCount();
        LottoRequest request = new LottoRequest(money, manuelLottoNumbers);

        LottoWallet lottoWallet = request.buy();

        OutputView.printLottoWallet(lottoWallet);

        String inputStr = InputView.getWinningNumbers();
        List<String> winningNumbers = List.of(inputStr.split(","));
        int bonusNumber = InputView.getBonusNumbers();

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new Lotto(winningNumbers), new LottoNumber(bonusNumber));
        LottoResult lottoResult = lottoWallet.calculateResult(lottoWinningNumber);

        OutputView.printLottoResult(lottoResult);
    }
}
