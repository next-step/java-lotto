package lotto.domain;

import lotto.common.Constant;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame_ref {
    private LastWonLottoNumber_ref lastWonLottoNumberRef;
    private InputView inputView;
    private ResultView resultView;

    public LottoGame_ref() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void LottoStart() {
        inputView.inputMoneyForLotto();
        int lottoCount = availablePurchaseCount(inputView.getInputAmount());
        resultView.printPurchasedCount(lottoCount);
        LottoNumbersList_ref lottoNumbersListRef = purchaseLottos(lottoCount);
        resultView.printPurchasedLottos(lottoNumbersListRef);
        inputView.inputLastWonLottoNumbers();
        inputView.inputBonusLottoNumber();
        resultView.printLottoGameResult(resultLottoGame(inputView, lottoNumbersListRef), inputView.getInputAmount());
    }

    public int availablePurchaseCount(int amount) {
        return amount / Constant.LOTTO_PRICE.value();
    }

    public LottoNumbersList_ref purchaseLottos(int lottoCount) {
        LottoNumbersList_ref lottoNumbersListRef = new LottoNumbersList_ref();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbersListRef.appendLottoNumber(purchaseOneLotto());
        }
        return lottoNumbersListRef;
    }

    public LottoNumbers_ref purchaseOneLotto() {
        LottoNumbers_ref lottoNumbersRef = new LottoNumbers_ref(new LottoNumberGeneratorRef());
        return lottoNumbersRef;
    }

    public ResultAllLottoScores resultLottoGame(InputView inputView, LottoNumbersList_ref lottoNumbersListRef) {
        return lottoNumbersListRef.countMatchedNumbersList(setLastWonLottoNumbers(inputView));
    }

    private LastWonLottoNumber_ref setLastWonLottoNumbers(InputView inputView) {
        lastWonLottoNumberRef = new LastWonLottoNumber_ref(inputView.getInputLastWonLottoNumbers(), inputView.getInputBonusNumber());
        return lastWonLottoNumberRef;
    }
}
