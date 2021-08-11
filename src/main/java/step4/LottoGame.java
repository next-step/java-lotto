package step4;

import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.LottoMatch;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.Lottos;
import step4.domain.lotto.Profit;
import step4.domain.lotto.RandomStrategy;
import step4.domain.lotto.WinOfLotto;
import step4.domain.money.Cache;
import step4.domain.money.Money;
import step4.domain.user.User;
import step4.domain.user.Wallet;
import step4.view.InputView;
import step4.view.ResultView;
import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        User user = new User("pobi", new Wallet(new Cache(inputMoney)));
        LottoMachine lottoMachine = new LottoMachine(new RandomStrategy());

        Money allMoney = user.withDraw();
        Lottos boughtLottos = lottoMachine.sell(allMoney);
        user.buyLotto(boughtLottos);

        ResultView.printCount(user.getLottos());
        ResultView.printLottos(user.getLottos());

        List<LottoNumber> winOfLottoNumbers = InputView.inputWinOfLottoNumber();
        LottoNumber lottoBonusNumber = InputView.inputBonusOfLottoNumber();
        winOfLottoNumbers.add(lottoBonusNumber);

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, lottoBonusNumber);

        Lottos lottos = user.getLottos();
        LottoMatch lottoMatch = lottos.match(winOfLotto);

        Profit profit = lottoMatch.calcProfit(user.getLottos().size());

        ResultView.printLottoStatistics(lottoMatch, profit);
    }
}
