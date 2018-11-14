package raffle.domain.lotto.play;

import raffle.domain.lotto.LottoMachine;
import raffle.domain.lotto.money.Money;
import raffle.domain.lotto.win.LottoResult;
import raffle.domain.lotto.win.LottosCreation;
import raffle.view.console.InputView;
import raffle.view.console.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        Money money = new Money(InputView.buyLotto() , InputView.lottoAmount());
        LottoMachine lottoMachine =
                new LottoMachine(money , new LottosCreation(InputView.getLottoNumber(money.getManualCount())));
        resultView.buyLotto(lottoMachine.getLottos(), money.getManualCount());

        LottoResult lottoResult = lottoMachine.winLotto(InputView.lastWeekLotto(), InputView.bonusLotto());
        resultView.result(lottoResult);

    }
}
