package lotto;

import lotto.domain.*;
import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.enterMoney());

        LottoMachine lottoMachine = new LottoMachine(money.computeLottoTickets());
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets();
        OutputView.printLottoTickets(lottoTickets.getLottoTickets());

        LottoGame lottoGame = new LottoGame(lottoTickets);
        WinningLottoNumbers winningLottoNumbers =
                new WinningLottoNumbers(InputView.enterWinningNumbers(), InputView.enterBonusBall());
        LottoResult lottoResult = new LottoResult(lottoGame.matchNumbers(winningLottoNumbers));
        OutputView.printResults(lottoResult, money);
    }
}
