package study.step3.controller;

import study.step3.domain.LottoResult;
import study.step3.domain.LottoShop;
import study.step3.domain.LottoTickets;
import study.step3.domain.WinningLotto;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class LottoGameLauncher {
    public static void main(String[] args) {
        long price = InputView.inputMoney();

        LottoTickets lottoTickets = LottoShop.buyLottoTickets(price);
        ResultView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = InputView.inputLastWinningNumbers();
        LottoResult lottoResult = lottoTickets.confirmWinningResult(winningLotto);
        ResultView.printLottoResult(lottoResult);
    }
}