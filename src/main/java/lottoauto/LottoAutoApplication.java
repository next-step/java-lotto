package lottoauto;

import java.util.List;
import lottoauto.model.*;
import lottoauto.model.request.LottoRequest;
import lottoauto.view.InputView;
import lottoauto.view.OutputView;

public class LottoAutoApplication {

    public static void main(String[] args) {
        int price = InputView.price();
        int manualCount = InputView.lotteryManual();
        List<Lotto> manualLottos = InputView.inputManualNumber(manualCount);

        LottoRequest lottoRequest = new LottoRequest(price, manualLottos);
        Lottos lottos = Lottos.from(lottoRequest);

        OutputView.lottos(lottos, manualCount);
        List<LottoNumber> winningNumbers = InputView.winningNumber();
        LottoNumber bonusNumber = LottoNumber.from(InputView.bonus());

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult lottoResult = winningLotto.result(lottos);

        OutputView.statistics(lottoResult, price);

    }
}
