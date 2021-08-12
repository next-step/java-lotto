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
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = new Lottos();

        manualLotto(lottos, user, lottoMachine);
        randomLotto(lottos, user, lottoMachine);

        user.buyLotto(lottos);

        ResultView.printCount(user.getLottos());
        ResultView.printLottos(user.getLottos());

        List<LottoNumber> winOfLottoNumbers = InputView.inputWinOfLottoNumber();
        LottoNumber lottoBonusNumber = InputView.inputBonusOfLottoNumber();

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, lottoBonusNumber);

        LottoMatch lottoMatch = user.getLottos().match(winOfLotto);
        Profit profit = lottoMatch.calcProfit(user.getLottos().size());

        ResultView.printLottoStatistics(lottoMatch, profit);
    }

    private static void randomLotto(Lottos lottos, User user, LottoMachine lottoMachine) {
        Money remainMoney = user.withDraw();
        lottos.addAll(lottoMachine.sell(remainMoney, new RandomStrategy()));
    }

    private static void manualLotto(Lottos lottos, User user, LottoMachine lottoMachine) {
        int lottoManualCount = InputView.inputManualCount();

        InputView.manualOfLottoView();

        for (int i = 0; i < lottoManualCount; i++) {
            List<LottoNumber> lottoNumbers = InputView.inputManualOfLottoNumber();

            Money manualLottoMoney = user.withDraw(new Cache(LottoMachine.LOTTO_PRICE));
            lottos.addAll(lottoMachine.sell(manualLottoMoney, () -> lottoNumbers));
        }
    }
}
