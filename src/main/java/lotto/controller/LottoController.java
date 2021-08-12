package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RandomNumber;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void playLotto() {
        int lottoCount = InputView.buyLotto();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(RandomNumber.makeLottoNumbers());
            lottos.add(lotto);
            ResultView.printLotto(lotto);
        }

        Lottos player = new Lottos(lottos);
        Lotto win = new Lotto(InputView.inputWinningNumber());

        ResultView.printWinTitle();
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.NOTHING)) continue;
            ResultView.printRankCount(rank, player.findRankCount(win, rank));
        }

        ResultView.printProfit(player.calculateProfit(win, lottoCount * LOTTO_PRICE));
    }
}
