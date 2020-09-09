package AutoLotto;

import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.play.PlayLotto;
import AutoLotto.domain.play.PlayLottoResult;

import java.util.Arrays;
import java.util.List;

import static AutoLotto.view.InputView.getBuzzLotto;
import static AutoLotto.view.InputView.getMoney;
import static AutoLotto.view.OutputView.*;

public class playLottoMain {

    public static void main(String[] args){
        int money = getMoney();
        printLottosCount(money);

        List<UserLotto> userLottos = new UserLottos(money).getUserLottos();
        printUserLottos(userLottos);

        List<LottoNumber> buzzLotto = getBuzzLotto();

        PlayLottoResult playLottoResult = new PlayLottoResult();

        PlayLotto playLotto = new PlayLotto(money, userLottos, buzzLotto);
        playLotto.countMatchAll(playLottoResult);

        printPlayLottoResult(playLottoResult);
        printPlayProfitResult(money, playLottoResult);
    }
}
