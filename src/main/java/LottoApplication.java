import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.User;
import step2.domain.WinningLotto;
import step2.domain.view.InputView;
import step2.domain.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        User user = new User(inputView.inputMoney());

        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.makeLotto(user.getMoney());

        user.setMyLotto(lotto);
        outputView.viewLottoNumbers(lotto);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers());
        winningLotto.getResult(lotto);

    }
}
