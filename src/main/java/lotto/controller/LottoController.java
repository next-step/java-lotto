package lotto.controller;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoController {

    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        lotto();
    }

    public static void lotto() {

        String lottoPriceStr = inputView.setBuyLottoPrice();
        resultView.resultOfBuyLotto(lottoPriceStr);

        resultView.resultOfLottoList(null);


        String lottoNumberStr = inputView.setLottoNumber();
    }
}
