package lotto.controller;

import java.util.List;

import lotto.domain.Lottos;
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
            final Lottos lottos = buyLottos();
            outputView.printLottoPurchaseHistory(lottos);

            final LottoResult lottoResult = judgeLottos(lottos);
            outputView.printLottoWinningResult(lottoResult);

        } catch (final IllegalArgumentException e) {
            outputView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            outputView.printUnexpectedExceptionMessage();
        }
    }

    private Lottos buyLottos() {
        final int totalPrice = inputView.readLottoTotalPrice();
        final int manualCount = inputView.readManualLottoCount();
        final List<List<Integer>> manualNumbers = inputView.readLottoManualNumbers(manualCount);

        return lottoMachine.publish(totalPrice, manualNumbers);
    }

    private LottoResult judgeLottos(final Lottos lottos) {
        final WinningLotto winningLotto = WinningLotto.of(
                inputView.readLottoWinningNumbers(),
                inputView.readLottoBonusNumber()
        );

        return lottoMachine.judge(lottos, winningLotto);
    }
}
