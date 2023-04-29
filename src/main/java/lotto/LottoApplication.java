package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = InputView.buy();
        LottoService lottoService = new LottoService(inputView.money());
        lottoService.autoGenerate();
        ResultView.showLottos(lottoService.lottos());

        Lotto lastWinLottoInfo = Lotto.manual(inputView.lastWeekWinNumbers());
        ResultView.showlastWinLottoInfo(lastWinLottoInfo);
    }
}
