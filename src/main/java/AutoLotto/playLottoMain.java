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
        int money = getMoney(); //3000입력
        printLottosCount(money);
        //List<UserLotto> userLottos = UserLottos.buyLottosWith(money);

        UserLotto userLotto1 = new UserLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))); //3
        UserLotto userLotto2 = new UserLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(8), new LottoNumber(16), new LottoNumber(32))); //2
        UserLotto userLotto3 = new UserLotto(Arrays.asList(new LottoNumber(4), new LottoNumber(6), new LottoNumber(8),
                new LottoNumber(10), new LottoNumber(12), new LottoNumber(14))); //5
        List<UserLotto> userLottos = Arrays.asList(userLotto1, userLotto2, userLotto3);

        printUserLottos(userLottos);
        printEmptyLine();
        List<LottoNumber> buzzLotto = getBuzzLotto();
        System.out.print(buzzLotto);

        PlayLottoResult playLottoResult = new PlayLottoResult();
        PlayLotto playLotto = new PlayLotto(money, userLottos, buzzLotto);

        printPlayLottoResult(playLottoResult, playLotto);
        printPlayProfitResult(money, playLottoResult);
    }
}
