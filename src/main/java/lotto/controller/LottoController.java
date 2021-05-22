package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        LottoNumbersGenerator store = new LottoNumbersGenerator(new RandomNumbersGenerator());

        int price = inputView.inputPrice();

        List<LottoNumbers> lottoNumbersList = store.generate(price);
        printView.printLottoNumbers(lottoNumbersList);

        LottoTickets lottoTickets = LottoTickets.of(lottoNumbersList, WinningNumbers.of(inputView.inputWinningNumbers(), inputView.inputBonusNumber()));

        LottoResult lottoResult = lottoTickets.matchResult();
        printView.printResult(lottoResult, price);
    }
}
