package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private LastWonLottoNumber lastWonLottoNumber;
    private InputView inputView;
    private ResultView resultView;

    public PurchaseLotto() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void LottoStart() {
        inputView.inputPurchaseAmount();
        int lottoCount = availablePurchaseLottoCount(inputView.getInputAmount());
        resultView.printPurchasedCount(lottoCount);
        LottoNumbersList lottoNumbersList = purchaseAvailableLotto(lottoCount);
        resultView.printPurchasedLottos(lottoNumbersList);
        inputView.inputLastWonLottoNumbers();
        inputView.inputBonusLottoNumber();
        resultView.printLottoGameResult(resultLottoGame(inputView, lottoNumbersList), inputView.getInputAmount());
    }

    public int availablePurchaseLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public LottoNumbersList purchaseAvailableLotto(int lottoCount) {
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbersList.appendLottoNumber(purchaseOneLotto());
        }
        return lottoNumbersList;
    }

    public LottoNumbers purchaseOneLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGenerator());
        return lottoNumbers;
    }

    public ResultAll resultLottoGame(InputView inputView, LottoNumbersList lottoNumbersList) {
        return lottoNumbersList.countMatchedNumbersList(setLastWonLottoNumbers(inputView));
    }

    private LastWonLottoNumber setLastWonLottoNumbers(InputView inputView) {
        lastWonLottoNumber = new LastWonLottoNumber(inputView.getInputLastWonLottoNumbers(), inputView.getInputBonusNumber());
        return lastWonLottoNumber;
    }
}
