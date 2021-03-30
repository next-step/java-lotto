package step2;

import step2.domain.Lotto;
import step2.domain.User;
import step2.view.InputView;
import step2.view.ResultView;

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

        // 돈
        buyLotto(lottoCount);

        displayLotto();
        // 당첨 통계
    }

    private void displayLotto() {
        resultView.displayLotto(user.getLottoList());
    }

    private void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            user.buyLotto(defaultLotto);
        }
    }

    public int winningConfirm(Lotto winningLotto, Lotto lotto) {
        int count = 0;
        List<Integer> lottoList = lotto.getLottoNumber();

        for (int i = 0; i < lottoList.size(); i++) {
            count += winningLotto.numberConfirm(lottoList.get(i));
        }
        return count;
    }
}
