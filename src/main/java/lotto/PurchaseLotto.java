package lotto;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private LottoNumbers lottoNumbers;
    private LottoNumbersList lottoNumbersList;
    private LastWonLottoNumber lastWonLottoNumber;
    private ResultAll resultAll;
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
        resultLottoGame(inputView);
        resultView.printLottoGameResult(lottoNumbersList.getResultAll(), inputView.getInputAmount());
    }

    public int availablePurchaseLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public LottoNumbersList purchaseAvailableLotto(int lottoCount) {
        lottoNumbersList = new LottoNumbersList();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbersList.appendLottoNumber(purchaseOneLotto());
        }
        return lottoNumbersList;
    }

    public LottoNumbers purchaseOneLotto() {
        lottoNumbers = new LottoNumbers(new LottoNumberGenerator());
        return lottoNumbers;
    }

    public void resultLottoGame(InputView inputView) {
        setLastWonLottoNumbers(inputView);
        lottoNumbersList.countMatchedNumbersList(lastWonLottoNumber);
    }

    private void setLastWonLottoNumbers(InputView inputView) {
        this.lastWonLottoNumber = new LastWonLottoNumber(inputView.getInputLastWonLottoNumbers(), inputView.getInputBonusNumber());
    }
}
