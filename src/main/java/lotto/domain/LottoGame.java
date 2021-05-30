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
        int inputMoney = inputView.inputMoneyForLotto();
        int manualLottoCount = inputView.inputCountForManualLotto();
        int lottoCount = availablePurchaseCount(inputMoney);
        resultView.printPurchasedCount(lottoCount);
        LottoNumbersList lottoNumbersList = purchaseLottos(lottoCount);
        resultView.printPurchasedLottos(lottoNumbersList);
        String inputLastWonLottoNumbers = inputView.inputLastWonLottoNumbers();
        String inputBonusLottoNumber = inputView.inputBonusLottoNumber();
        resultView.printLottoGameResult(resultLottoGame(inputLastWonLottoNumbers, inputBonusLottoNumber, lottoNumbersList), inputMoney);
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

    public ResultAllLottoScores resultLottoGame(String inputLastWonLottoNumbers, String inputBonusLottoNumber, LottoNumbersList lottoNumbersList) {
        return lottoNumbersList.countMatchedNumbersList(setLastWonLottoNumbers(inputLastWonLottoNumbers, inputBonusLottoNumber));
    }

    private LastWonLottoNumber setLastWonLottoNumbers(String inputLastWonLottoNumbers, String inputBonusLottoNumber) {
        lastWonLottoNumber = new LastWonLottoNumber(inputLastWonLottoNumbers, inputBonusLottoNumber);
        return lastWonLottoNumber;
    }
}
