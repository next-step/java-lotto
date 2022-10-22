package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static void main(String[] args) {
        Store store = new Store(InputView.getMoney());
        List<LottoTicket> lottoTickets = store.getLottoTickets();

        ResultView.viewCountOfLotto(lottoTickets.size());
        ResultView.viewLottoTickets(lottoTickets);

        List<LottoNumber> winningNumbers = InputView.getWinningNumbers()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        List<Rank> ranks = store.match(winningNumbers);
        System.out.println(ranks);
    }
}
