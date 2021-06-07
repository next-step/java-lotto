package study.ascii92der.lotto.step3to5;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    public static final String ERROR_MASSAGE_INPUT_NUMBER = "숫자를 입력해주세요.";
    public static final String ERROR_MASSAGE_INPUT_INVALID = "입력 값이 올바르지 않습니다. ";

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            LottoPrice lottoPrice = inputView.inputMoney();

            LottoPrice manualLottoPrice = inputView.inputManualLottoCount();

            LottoPrice balanceLottoPrice = lottoPrice.differenceLottoPrice(manualLottoPrice);

            Lottos manualLottos = inputView.inputManualLottos(manualLottoPrice);

            resultView.printLottoCount(manualLottoPrice, balanceLottoPrice);

            Lottos autoLottos = (new LottoGenerator()).generateLottos(balanceLottoPrice);

            Lottos totalLottos = autoLottos.merge(manualLottos);

            resultLotto(totalLottos);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void resultLotto(Lottos lottos) {
        resultView.printLottoNumbers(lottos);
        WinningLotto winningLotto = new WinningLotto(inputView.inputWinnerNumbers(),
                inputView.inputBonusNumber());

        WinResult winResult = new WinResult(lottos, winningLotto);
        resultView.printWinnerResult(winResult);

    }

    private void handleException(Exception e) {
        if (e.getClass().equals(NumberFormatException.class)) {
            System.out.println(ERROR_MASSAGE_INPUT_NUMBER);
            return;
        }

        if (e.getClass().equals(IllegalArgumentException.class)) {
            System.out.println(ERROR_MASSAGE_INPUT_INVALID + e.getMessage());
            return;
        }
    }

}
