package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Lottos lottos = purchageLottos();
        WinningLotto winningLotto = inputWinningLotto();
        printReport(lottos, winningLotto);
    }

    private static Lottos purchageLottos() {
        Amount inputAmount = InputView.purchase();
        Lottos manualLottos = InputView.manualLottos();

        Amount autoLottoAmount = new Amount(inputAmount.minus(manualLottos.totalAmount()));
        Lottos autoLottos = Lottos.from(autoLottoAmount);

        ResultView.printLottos(manualLottos, autoLottos);
        return manualLottos.merged(autoLottos);
    }

    private static WinningLotto inputWinningLotto() {
        return new WinningLotto(
                InputView.winningNumbers(),
                InputView.BonusNumber()
        );
    }

    private static void printReport(Lottos lottos, WinningLotto winningLotto) {
        Ranks ranks = winningLotto.ranks(lottos);
        LottoResult lottoResult = new LottoResult(ranks, lottos.totalAmount());
        ResultView.printReport(lottoResult);
    }
}
