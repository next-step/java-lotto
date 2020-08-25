import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.WinningLotto;
import step2.domain.view.InputView;
import step2.domain.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.makeLotto(inputView.inputMoney());

        OutputView outputView = new OutputView();
        outputView.viewLottoNumbers(lotto);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers());
        winningLotto.getResult(lotto);

    }
}
