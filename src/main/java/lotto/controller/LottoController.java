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
            final int totalPrice = inputView.getTotalPrice();
            final int purchaseManualLottoNumber = inputView.getPurchaseManualLottoNumber();
            final LottoPlay lottoPlay;

            lottoPlay = getLottoPlay(totalPrice, purchaseManualLottoNumber);

            resultView.printNumberOfLotto(lottoPlay.getLottoRandomMatchCount(),
                lottoPlay.getLottoManualMatchCount());

            if (lottoPlay.getLottoRandomMatchCount() > IS_POSSIBLE_LOTTO_PURCHASE) {
                resultView.printLottoTickets(lottoPlay.getLottoTickets());
            }

            lottoPlay.run(new LottoMachine(inputView.getWinNumbers(), inputView.getBonusNumber()));

            resultView.printAnalyzeResults(lottoPlay.getWinningPrices(),
                lottoPlay.calculateProfitPercent());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
