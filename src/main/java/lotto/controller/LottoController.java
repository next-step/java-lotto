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
        LottoTickets lottoTickets = store.buy(StringUtils.parseInteger(inputView.getPrice()));

        printView.printLottoNumbers(lottoTickets);

    }
}
