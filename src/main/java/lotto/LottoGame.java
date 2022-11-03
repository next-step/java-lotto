package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Store;
import lotto.domain.WinningLotto;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        Store store = new Store(new RandomLottoGenerator(), money);
        List<LottoTicket> lottoTickets = store.getLottoTickets();

        ResultView.viewCountOfLotto(lottoTickets.size());
        ResultView.viewLottoTickets(lottoTickets);

        WinningLotto winningLotto = new WinningLotto(new LottoTicket(InputView.getWinningNumbers()), LottoNumber.valueOf(InputView.getBonusNumber()));
        ResultView.viewWinningStatics(new LottoResult(store.match(winningLotto)), money);
    }
}
