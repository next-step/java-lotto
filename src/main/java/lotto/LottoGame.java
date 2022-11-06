package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Store;
import lotto.domain.WinningLotto;
import lotto.domain.lottogenerator.ManualLottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        Store manualStore = new Store(new ManualLottoGenerator(InputView.getManualLottoNumbers()));
        Store randomStore = new Store(new RandomLottoGenerator(money.countOfTickets()));
        Store totalStore = new Store(List.of(manualStore, randomStore));

        ResultView.viewCountOfLotto(manualStore.sizeOfLottoTickets(), randomStore.sizeOfLottoTickets());
        ResultView.viewLottoTickets(totalStore.getLottoTickets());

        WinningLotto winningLotto = new WinningLotto(new LottoTicket(InputView.getWinningNumbers()), LottoNumber.valueOf(InputView.getBonusNumber()));
        ResultView.viewWinningStatics(new LottoResult(totalStore.match(winningLotto)), money);
    }
}
