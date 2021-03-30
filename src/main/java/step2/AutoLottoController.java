package step2;

import step2.domain.Lotto;
import step2.domain.User;
import step2.util.StringUtil;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class AutoLottoController {

    InputView inputView;
    ResultView resultView;
    User user;
    Lotto defaultLotto;

    public AutoLottoController() {
        inputView = new InputView();
        resultView = new ResultView();
        user = new User();
        defaultLotto = new Lotto();
    }

    public void run() {
        int lottoCount = inputView.inputPrize();
        resultView.displayLottoCount(lottoCount);

        buyLotto(lottoCount);

        Lotto winningLotto = new Lotto(StringUtil.stringToList(inputView.inputWinningLotto()));

        lottery(winningLotto);
    }

    private void lottery(Lotto winningLotto) {

    }

    private void displayLotto() {
        resultView.displayLotto(user.getLottoList());
    }

    private void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            user.buyLotto(defaultLotto);
        }
        displayLotto();
    }


}
