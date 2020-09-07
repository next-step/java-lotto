package AutoLotto;

import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.play.PlayLotto;

import java.util.List;

import static AutoLotto.view.InputView.getBuzzLotto;
import static AutoLotto.view.InputView.getMoney;
import static AutoLotto.view.OutputView.*;

public class playLottoMain {

    public static void main(String[] args){
        int money = getMoney();
        printLottosCount(money);
        List<UserLotto> userLottos = UserLottos.buyLottosWith(money);
        printUserLottos(userLottos);
        printEmptyLine();
        PlayLotto playLotto = new PlayLotto(money, userLottos, getBuzzLotto());
        printPlayLottoResult(playLotto);
    }
}
