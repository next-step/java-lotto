package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.reward.LottoResult;
import lotto.domain.reward.WinningLotto;
import lotto.service.LottoMachine;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGame {

    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGame(
            final LottoInputView inputView,
            final LottoOutputView outputView,
            final LottoMachine lottoMachine
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        try {
            final List<Lotto> lottos = buyLottos();
            outputView.printLottoPurchaseHistory(lottos);

            final LottoResult lottoResult = judgeLottos(lottos);
            outputView.printLottoWinningResult(lottoResult);

        } catch (final IllegalArgumentException e) {
            outputView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            outputView.printUnexpectedExceptionMessage();
        }
    }

    private List<Lotto> buyLottos() {
        final int totalPrice = inputView.readLottoTotalPrice();

        return lottoMachine.publish(totalPrice);
    }

    private LottoResult judgeLottos(final List<Lotto> lottos) {
        final WinningLotto winningLotto = WinningLotto.of(
                inputView.readLottoWinningNumbers(),
                inputView.readLottoBonusNumber()
        );

        return lottoMachine.judge(lottos, winningLotto);
    }
}
