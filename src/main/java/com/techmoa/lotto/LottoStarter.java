package com.techmoa.lotto;

import com.techmoa.lotto.service.LottoService;
import com.techmoa.lotto.service.LottoTicket;
import com.techmoa.lotto.service.LottoTickets;
import com.techmoa.lotto.view.InputView;
import com.techmoa.lotto.view.OutputView;

public class LottoStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        inputView.enterPurchaseAmount();

        LottoService lottoService = new LottoService();
        lottoService.createLotto(inputView.getPurchaseAmount());
        LottoTickets lottoTickets = lottoService.getLottoTickets();
        outputView.printOwnLotto(lottoTickets);

        inputView.enterLastWinnerNumber();
        lottoService.checkWinnings(inputView.getLottoAnswer() , lottoTickets);
    }
}
