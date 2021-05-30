package lotto.domain;

import lotto.common.Constant;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private LastWonLottoNumber lastWonLottoNumber;
    private InputView inputView;
    private ResultView resultView;

    public LottoGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void LottoStart() {
        inputView.inputMoneyForLotto();
        int lottoCount = availablePurchaseCount(inputView.getInputAmount());
        resultView.printPurchasedCount(lottoCount);
        LottoNumbersList lottoNumbersList = purchaseLottos(lottoCount);
        resultView.printPurchasedLottos(lottoNumbersList);
        inputView.inputLastWonLottoNumbers();
        inputView.inputBonusLottoNumber();
        resultView.printLottoGameResult(resultLottoGame(inputView, lottoNumbersList), inputView.getInputAmount());
    }

    public int availablePurchaseCount(int amount) {
        return amount / Constant.LOTTO_PRICE.value();
    }

    public LottoNumbersList purchaseLottos(int lottoCount) {
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

    public ResultAllLottoScores resultLottoGame(InputView inputView, LottoNumbersList lottoNumbersList) {
        return lottoNumbersList.countMatchedNumbersList(setLastWonLottoNumbers(inputView));
    }

    private LastWonLottoNumber setLastWonLottoNumbers(InputView inputView) {
        lastWonLottoNumber = new LastWonLottoNumber(inputView.getInputLastWonLottoNumbers(), inputView.getInputBonusNumber());
        return lastWonLottoNumber;
    }
}
