package lotto;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = InputView.buy();
        LottoService lottoService = new LottoService(inputView.getMoney());
        lottoService.generate();
        ResultView.showLottos(lottoService.getLottos());
    }
}
