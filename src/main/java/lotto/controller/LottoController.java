package lotto.controller;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.dto.RankResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public Lottos buy() {
        Money fee = readBuyLottoFee();
        List<String> passivityLottosInput = readPassivityLottos();

        Lottos lottos = buyLottos(passivityLottosInput, fee);

        OutputView.renderingLottos(lottos);
        return lottos;
    }

    private Money readBuyLottoFee() {
        return new Money(InputView.readAmount());
    }

    private List<String> readPassivityLottos() {
        return InputView.readPassivityLotts(InputView.readPassivityLottoCount());
    }

    private Lottos buyLottos(List<String> passivityLottosInput, Money fee) {
        return lottoService.buyLottos(passivityLottosInput, fee);
    }


    public void check(Lottos lottos) {
        String winningNumbers = readWinningNumbers();
        int bonus = readBouns();

        RankResult result = matchAll(lottos, winningNumbers, bonus);

        OutputView.renderingWinningStatistics(result);
    }

    private static String readWinningNumbers() {
        return InputView.readWinningNumber();
    }

    private static int readBouns() {
        return InputView.readBonusNumber();
    }

    private static RankResult matchAll(Lottos lottos, String winningNumbers, int bonus) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonus);
        return new RankResult(lottos.matchAll(winningLotto));
    }
}
