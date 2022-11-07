package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.utils.RandomLottoGenerator;
import lotto.domain.Store;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;

public class LottoGame {

    public static void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        Store manualStore = new Store(InputView.getManualLottoNumbers().stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList()));
        Store randomStore = new Store(RandomLottoGenerator.create(money.countOfTickets()));
        Store totalStore = manualStore.add(randomStore);

        ResultView.viewCountOfLotto(manualStore.sizeOfLottoTickets(), randomStore.sizeOfLottoTickets());
        ResultView.viewLottoTickets(totalStore.getLottoTickets());

        WinningLotto winningLotto = new WinningLotto(new LottoTicket(InputView.getWinningNumbers()), LottoNumber.valueOf(InputView.getBonusNumber()));
        ResultView.viewWinningStatics(new LottoResult(totalStore.match(winningLotto)), money);
    }
}
