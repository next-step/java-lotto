package lotto.controller;


import lotto.domain.LottoShop;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoResultView lottoResultView;
    private final LottoShop lottoShop;

    public LottoController(final LottoInputView lottoInputView,
        final LottoResultView lottoResultView, final LottoShop lottoShop) {
        this.lottoInputView = lottoInputView;
        this.lottoResultView = lottoResultView;
        this.lottoShop = lottoShop;
    }

    public void run() {
        setUp();
        startLotto();
        analyzeStatistics();
    }

    private void setUp() {
        lottoInputView.prepareLottoGame(lottoShop);
    }

    private void startLotto() {
        lottoResultView.findWinner(lottoInputView.getWinningNumbers(), lottoInputView.getLottos(),
            lottoInputView.getBonusBall());
    }

    private void analyzeStatistics() {
        lottoResultView.finishGame(lottoInputView.getPrice());
    }
}
