package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPlay;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private static final int IS_POSSIBLE_LOTTO_PURCHASE = 0;

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            final LottoPlay lottoPlay = lottoPlayInit();

            resultView.printNumberOfLotto(lottoPlay.getLottoRandomCount(),
                lottoPlay.getLottoManualMatchCount());

            hasPurChaseRandomLotto(lottoPlay);

            lottoPlay.run(new LottoMachine(inputView.getWinNumbers(), inputView.getBonusNumber()));

            resultView.printAnalyzeResults(lottoPlay.getWinningPrices(),
                lottoPlay.calculateProfitPercent());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private LottoPlay lottoPlayInit() {
        final int totalPrice = inputView.getTotalPrice();
        final int purchaseManualLottoNumber = inputView.getPurchaseManualLottoNumber();
        final LottoPlay lottoPlay = getLottoPlay(totalPrice, purchaseManualLottoNumber);
        return lottoPlay;
    }

    private void hasPurChaseRandomLotto(final LottoPlay lottoPlay) {
        if (lottoPlay.getLottoRandomCount() > IS_POSSIBLE_LOTTO_PURCHASE) {
            resultView.printLottoTickets(lottoPlay.getLottoTickets());
        }
    }

    private LottoPlay getLottoPlay(int totalPrice, int purchaseManualLottoNumber) {
        final LottoPlay lottoPlay;
        if (purchaseManualLottoNumber > IS_POSSIBLE_LOTTO_PURCHASE) {
            lottoPlay = new LottoPlay(totalPrice, purchaseManualLottoNumber,
                inputView.getManualLottoNumbers(purchaseManualLottoNumber));
        } else {
            lottoPlay = new LottoPlay(totalPrice, purchaseManualLottoNumber);
        }
        return lottoPlay;
    }
}
