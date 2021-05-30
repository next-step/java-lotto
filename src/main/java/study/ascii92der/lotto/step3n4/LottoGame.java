package study.ascii92der.lotto.step3n4;

public class LottoGame {

    public static void start() {
        LottoPrice lottoPrice = InputView.inputMoney();
        ResultView.printLottoCount(lottoPrice);
        ResultView.printWinnerResult(
                new WinResult(
                        (new LottoGenerator())
                                .generateLottos(lottoPrice),
                        InputView.inputWinnerNumbers(), InputView.inputBonusNumber()));

    }
}
