package study.ascii92der.lotto.step3n4;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {

        LottoPrice lottoPrice = insertMoney();

        Lottos lottos = generateLottos(lottoPrice);

        resultLotto(lottos);
    }

    private LottoPrice insertMoney() {
        LottoPrice lottoPrice = inputView.inputMoney();
        resultView.printLottoCount(lottoPrice);

        return lottoPrice;
    }

    private Lottos generateLottos(LottoPrice lottoPrice) {
        Lottos lottos = (new LottoGenerator()).generateLottos(lottoPrice);
        resultView.printLottoNumbers(lottos);

        return lottos;
    }

    private void resultLotto(Lottos lottos) {
        WinningLotto winningLotto = new WinningLotto(inputView.inputWinnerNumbers(),
                inputView.inputBonusNumber());

        WinResult winResult = new WinResult(lottos, winningLotto);
        resultView.printWinnerResult(winResult);

    }

}
