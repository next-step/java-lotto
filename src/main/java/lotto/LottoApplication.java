package lotto;

import lotto.backend.controller.LottoController;
import lotto.backend.domain.LottoStatistics;
import lotto.backend.domain.LottoTickets;
import lotto.frontend.InputView;
import lotto.frontend.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoApplication.run();
    }

    public static void run() {
        LottoController lottoController = new LottoController();

        LottoTickets lottoTickets = lottoController.buy(InputView.askEnterMoney());
        ResultView.printLottoNumber(lottoTickets);

        LottoStatistics lottoStatistics = lottoController.match(InputView.askEnterWinningNumbers());
        ResultView.printLottoResult(lottoStatistics);
    }
}
