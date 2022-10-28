package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        Store store = new Store(money);
        List<LottoTicket> lottoTickets = store.getLottoTickets();

        ResultView.viewCountOfLotto(lottoTickets.size());
        ResultView.viewLottoTickets(lottoTickets);

        List<LottoNumber> winningNumbers = InputView.getWinningNumbers()
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        ResultView.viewWinningStatics(new LottoResult(store.match(winningNumbers, LottoNumber.valueOf(InputView.getBonusNumber()))), money);
    }
}
