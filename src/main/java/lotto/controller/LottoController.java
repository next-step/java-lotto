package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.PrintView;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        LottoTicketStore store = new LottoTicketStore(new RandomNumbersGenerator());

        int price = inputView.inputPrice();

        LottoTickets lottoTickets = store.buy(price);
        printView.printLottoNumbers(lottoTickets);

        LottoResult lottoResult = lottoTickets.matchResult(LottoTicket.of(inputView.inputWinningNumbers()));
        printView.printResult(lottoResult, price);
    }
}
