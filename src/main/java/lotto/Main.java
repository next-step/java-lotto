package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Price;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.*;

public class LottoGame {
    public static void main(String[] args) {
        Price price = InputView.getPrice();

        LottoTicket lottoTicket = LottoGame.buyLotto(price.getAvailableBuyTicketCount());
        for (Lotto lotto : lottos) {
            ResultView.printLotto(lotto);
        }

        Lotto winningLotto = new Lotto(InputView.getWinningNumbers());

//        List<Rank> ranks = new ArrayList<>();
//        for (Lotto lotto : lottos) {
//            ranks.add(LottoGame.match(lotto, winningLotto));
//        }

//        LottoResult result = new LottoResult(ranks);
//        BigDecimal yield = price.getYield(result.getTotalWinningMoney());
//        ResultView.printYield(yield);
    }

    public static LottoTicket buyLotto(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Set<LottoNumber> lottoNumbers = new HashSet<>();
            Random random = new Random();
            while (lottoNumbers.size() < 6) {
                lottoNumbers.add(new LottoNumber(random.nextInt(45) + 1));
            }
            lottos.add(new Lotto(new ArrayList<>(lottoNumbers)));
        }
        return new LottoTicket(lottos);
    }
}
