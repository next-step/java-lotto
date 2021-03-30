package step2;

import step2.domain.Lotto;
import step2.domain.User;

import java.util.List;

public class AutoLottoController {

    User user;
    Lotto defaultLotto;

    public AutoLottoController() {
        user = new User();
        defaultLotto = new Lotto();
    }

    public void run() {


        this.buyLotto(5);

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
