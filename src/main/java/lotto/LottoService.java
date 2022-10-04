package lotto;

import java.util.List;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void purchaseLotto() {
        List<Lotto> lottos = inputView.purchaseLotto();
        outputView.printPurchasedLotto(lottos);
        List<Integer> winningNumber = inputView.inputBeforeWinningNumber();
        outputView.statisticLotto(lottos, winningNumber);
    }
}
