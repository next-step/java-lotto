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
        lottoInputView.prepareLottoGame(lottoShop);
        lottoResultView.findWinner(lottoInputView.getWinningNumbers(), lottoInputView.getLottos(),
            lottoInputView.getBonusBall());
        lottoResultView.finishGame(lottoInputView.getPrice());
    }
}
