package lotto.controller;

import lotto.domain.LottoShop;
import lotto.domain.result.LottoResults;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoController {

    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        int lottoCount = inputView.getLottoCount();

        LottoShop lotto = new LottoShop();
        lotto.playLotto(lottoCount);

        resultView.printLottoNumber();

        WinningNumber.stringToNumber(inputView.inputWinningLottoNumbers());

        LottoResults lottoResults = lotto.getLottoResult(WinningNumber.winningNumber);
        resultView.printLottoStatistic(lottoResults);

//1, 2, 3, 4, 5, 6
    }
}
