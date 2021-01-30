package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView, outputView);

        // 로또를 구매하고, 확인하는 과정
        List<LottoTicket> lottoTickets = lottoController.purchaseLottoTickets();

        // 로또 결과를 보여주는 과정
        lottoController.getWinner(lottoTickets);
    }
}
