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
        int totalLottoCount = InputView.purchase();
        Lottos manualLottos = InputView.manualLottos(totalLottoCount);
        Lottos autoLottos = Lottos.from(totalLottoCount - manualLottos.size());

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
        float roi = winningLotto.roi(lottos);
        ResultView.printReport(ranks, roi);
    }
}
