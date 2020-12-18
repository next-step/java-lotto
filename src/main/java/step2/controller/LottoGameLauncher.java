package step2.controller;

import step2.domain.LottoResult;
import step2.domain.LottoShop;
import step2.domain.LottoTickets;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGameLauncher {
    public static void main(String[] args) {
        long price = InputView.inputMoney();

        LottoShop lottoShop = new LottoShop();
        LottoTickets lottoTickets = lottoShop.buyLottoTickets(price);
        ResultView.printLottoTickets(lottoTickets);

        String lastWinningNumbers = InputView.inputLastWinningNumbers();
        LottoResult lottoResult = lottoTickets.confirmWinningResult(lastWinningNumbers);
        ResultView.printLottoResult(lottoResult);
    }
}