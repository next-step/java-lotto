package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.*;

public class LottoController {
    public static void main(String[] args) {
        Price price = InputView.getPrice();
        List<Lotto> lottos = LottoController.buyLotto(price.getAvailableBuyTicketCount());
        for (Lotto lotto : lottos) {
            ResultView.printLotto(lotto.getLottoNumbers());
        }
        Lotto winningLotto = new Lotto(InputView.getWinningNumbers());
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(LottoGame.match(lotto, winningLotto));
        }
        double yield = price.getYield(ranks);
        ResultView.printYield(yield);
    }

    public static List<Lotto> buyLotto(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Set<LottoNumber> lottoNumbers = new HashSet<>();
            Random random = new Random();
            while (lottoNumbers.size() < 6) {
                lottoNumbers.add(new LottoNumber(random.nextInt(45) + 1));
            }
            lottos.add(new Lotto(new ArrayList<>(lottoNumbers)));
        }
        return lottos;
    }
}
