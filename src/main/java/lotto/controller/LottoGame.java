package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.reward.LottoResult;
import lotto.service.LottoMachine;
import lotto.view.LottoView;

public class LottoGame {

    private final LottoView lottoView;
    private final LottoMachine lottoMachine;

    public LottoGame(final LottoView lottoView, final LottoMachine lottoMachine) {
        this.lottoView = lottoView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        try {
            final List<Lotto> lottos = buyLottos();
            lottoView.printLottoPurchaseHistory(lottos);

            final LottoResult lottoResult = judgeLottos(lottos);
            lottoView.printLottoWinningResult(lottoResult);

        } catch (final IllegalArgumentException e) {
            lottoView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            lottoView.printUnexpectedExceptionMessage();
        }
    }

    private List<Lotto> buyLottos() {
        final int totalPrice = lottoView.readLottoTotalPrice();

        return lottoMachine.publish(totalPrice);
    }

    private LottoResult judgeLottos(final List<Lotto> lottos) {
        final int[] winningNumbers = lottoView.readLottoWinningNumbers();

        return lottoMachine.judge(lottos, winningNumbers);
    }
}
