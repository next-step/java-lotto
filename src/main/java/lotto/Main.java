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
        Lottos lottos = Lottos.from(InputView.purchase());
        ResultView.printLottos(lottos);
        return lottos;
    }

    private static WinningLotto inputWinningLotto() {
        return new WinningLotto(
                InputView.winningNumbers(),
                InputView.BonusNumber()
        );
    }

    private static void printReport(Lottos lottos, WinningLotto winningLotto) {
        Ranks ranks = winningLotto.ranks(lottos);
        LottoResult lottoResult = new LottoResult(ranks, lottos.totalPayment());
        ResultView.printReport(lottoResult);
    }
}
