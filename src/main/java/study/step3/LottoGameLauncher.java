package study.step3;

import study.step3.domain.LottoResult;
import study.step3.domain.LottoShop;
import study.step3.domain.LottoTickets;
import study.step3.view.InputView;
import study.step3.view.ResultView;

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
