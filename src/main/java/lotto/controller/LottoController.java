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

        inputView.inputPrice();
        int price = StringUtils.parseInteger(inputView.getPrice());

        LottoTickets lottoTickets = store.buy(price);

        printView.printLottoNumbers(lottoTickets);
        inputView.inputWinningNumbers();

        LottoResult lottoResult = lottoTickets.matchResult(LottoTicket.of(inputView.getWinningNumbers()));
        printView.printResult(lottoResult);
        printView.printProfitRate(lottoResult.calculateProfitRate(price));
    }
}
