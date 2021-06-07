package study.ascii92der.lotto.step3to5;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {

        LottoPrice lottoPrice = inputView.inputMoney();

        int manualLottoCount = inputView.inputManualLottoCount();

        Lottos manualLottos = inputView.inputManualLottos(manualLottoCount);

        LottoPrice balanceLottoPrice = lottoPrice.differenceLottoPrice(manualLottoCount);

        resultView.printLottoCount(manualLottoCount, balanceLottoPrice);

        Lottos autoLottos = (new LottoGenerator()).generateLottos(lottoPrice);

        Lottos totalLottos = autoLottos.merge(manualLottos);

        resultLotto(totalLottos);
    }

    private void resultLotto(Lottos lottos) {
        resultView.printLottoNumbers(lottos);
        WinningLotto winningLotto = new WinningLotto(inputView.inputWinnerNumbers(),
                inputView.inputBonusNumber());

        WinResult winResult = new WinResult(lottos, winningLotto);
        resultView.printWinnerResult(winResult);

    }

}
