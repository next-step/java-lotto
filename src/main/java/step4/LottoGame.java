package step4;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.LottoMatch;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.Lottos;
import step4.domain.lotto.Profit;
import step4.domain.lotto.WinOfLotto;
import step4.domain.money.Cache;
import step4.domain.user.User;
import step4.domain.user.Wallet;
import step4.view.InputView;
import step4.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        User user = new User("pobi", new Wallet(new Cache(inputMoney)));

        int lottoManualCount = InputView.inputManualCount();
        InputView.manualOfLottoView();

        Lottos lottos = new Lottos(manualLotto(user, lottoManualCount), LottoMachine.randomLottoBulk(user.withDraw()));

        user.buyLotto(lottos);

        ResultView.printCount(user.getLottos());
        ResultView.printLottos(user.getLottos());

        List<LottoNumber> winOfLottoNumbers = InputView.inputWinOfLottoNumber();
        LottoNumber lottoBonusNumber = InputView.inputBonusOfLottoNumber();

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, lottoBonusNumber);

        LottoMatch lottoMatch = user.getLottos().match(winOfLotto);
        Profit profit = lottoMatch.calcProfit(user.getLottos().getLottoCount());

        ResultView.printLottoStatistics(lottoMatch, profit);
    }

    private static List<Lotto> manualLotto(User user, int lottoManualCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoManualCount; i++) {
            List<LottoNumber> lottoNumbers = InputView.inputManualOfLottoNumber();
            lottos.add(LottoMachine.manualLotto(user.withDraw(new Cache(LottoMachine.LOTTO_PRICE)), lottoNumbers));
        }
        return lottos;
    }
}
