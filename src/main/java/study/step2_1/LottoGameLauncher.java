package study.step2_1;

import study.step2_1.domain.LottoResult;
import study.step2_1.domain.LottoShop;
import study.step2_1.domain.LottoTickets;
import study.step2_1.view.InputView;
import study.step2_1.view.ResultView;

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
