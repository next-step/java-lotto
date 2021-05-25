package lotto;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private LottoNumber lottoNumber;
    private LottoNumberList lottoNumberList;
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
        LottoNumberList lottoNumberList = purchaseAvailableLotto(lottoCount);
        resultView.printPurchasedLottos(lottoNumberList);
        inputView.inputLastWonLottoNumbers();
        inputView.inputBonusLottoNumber();
        resultLottoGame(inputView);
        resultView.printLottoGameResult(resultAll, inputView.getInputAmount());
    }

    public int availablePurchaseLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public LottoNumberList purchaseAvailableLotto(int lottoCount) {
        lottoNumberList = new LottoNumberList();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumberList.appendLottoNumber(purchaseOneLotto());
        }
        return lottoNumberList;
    }

    public LottoNumber purchaseOneLotto() {
        lottoNumber = new LottoNumber(new LottoNumberGenerator());
        return lottoNumber;
    }

    public void resultLottoGame(InputView inputView) {
        setLastWonLottoNumbers(inputView);
        resultAll = new ResultAll();
        Lotto lottoCompare = new Lotto();

        SameNumberCountInALotto sameNumberCountInALotto;
        for (int i = 0; i < lottoNumberList.count(); i++) {
            sameNumberCountInALotto = lottoCompare.countWonNumbers(lottoNumberList.get(i).getLottoNumbers(), lastWonLottoNumber);
            updateResultLotto(sameNumberCountInALotto);
        }
    }

    private void updateResultLotto(SameNumberCountInALotto sameNumberCountInALotto) {
        resultAll.won(sameNumberCountInALotto);
    }

    private void setLastWonLottoNumbers(InputView inputView) {
        this.lastWonLottoNumber = new LastWonLottoNumber(inputView.getInputLastWonLottoNumbers(), inputView.getInputBonusNumber());
    }
}
