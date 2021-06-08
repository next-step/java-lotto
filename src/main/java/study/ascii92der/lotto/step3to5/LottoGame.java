package study.ascii92der.lotto.step3to5;

public class LottoGame {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    public static final String ERROR_MASSAGE_INPUT_NUMBER = "숫자를 입력해주세요.";
    public static final String ERROR_MASSAGE_INPUT_INVALID = "입력 값이 올바르지 않습니다. ";

    public LottoGame(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void run() {
        try {
            LottoPrice lottoPrice = lottoInput.inputMoney();

            LottoPrice manualLottoPrice = lottoInput.inputManualLottoCount();

            LottoPrice balanceLottoPrice = lottoPrice.differenceLottoPrice(manualLottoPrice);

            Lottos manualLottos = lottoInput.inputManualLottos(manualLottoPrice);

            lottoOutput.printLottoCount(manualLottoPrice, balanceLottoPrice);

            Lottos autoLottos = (new LottoGenerator()).generateLottos(balanceLottoPrice);

            Lottos totalLottos = autoLottos.merge(manualLottos);

            resultLotto(totalLottos);
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void resultLotto(Lottos lottos) {
        lottoOutput.printLottoNumbers(lottos);
        WinningLotto winningLotto = new WinningLotto(lottoInput.inputWinnerNumbers(),
                lottoInput.inputBonusNumber());

        WinResult winResult = new WinResult(lottos, winningLotto);
        lottoOutput.printWinnerResult(winResult);

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
