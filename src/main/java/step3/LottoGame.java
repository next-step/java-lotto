package step3;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoMachine;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoStatistics;
import step3.domain.lotto.Profit;
import step3.domain.lotto.RandomStrategy;
import step3.domain.lotto.ResultOfLottos;
import step3.domain.lotto.WinOfLotto;
import step3.domain.money.Cache;
import step3.domain.money.Money;
import step3.domain.user.User;
import step3.domain.user.Wallet;
import step3.view.InputView;
import step3.view.ResultView;
import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        User user = new User("pobi", new Wallet(new Cache(inputMoney)));
        LottoMachine lottoMachine = new LottoMachine(new RandomStrategy());

        Money allMoney = user.withDraw();
        List<Lotto> boughtLottos = lottoMachine.sell(allMoney);
        user.buyLotto(boughtLottos);

        ResultView.printCount(user.getLottos());
        ResultView.printLottos(user.getLottos());

        Lotto winOfLottoNumbers = InputView.inputWinOfLottoNumber();
        LottoNumber lottoBonusNumber = InputView.inputBonusOfLottoNumber();

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, lottoBonusNumber);

        ResultOfLottos resultOfLottos = LottoStatistics.calcLottoOfStatistics(winOfLotto, user.getLottos());
        Profit profit = LottoStatistics.calculateLottoProfit(resultOfLottos, user.getLottos().size());

        ResultView.printLottoStatistics(resultOfLottos, profit);
    }
}
