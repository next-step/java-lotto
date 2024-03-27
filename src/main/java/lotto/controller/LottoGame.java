package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.reward.LottoRank;
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
            // 1. 로또 구매
            final int totalPrice = lottoView.readLottoTotalPrice();
            final List<Lotto> lottos = lottoMachine.publish(totalPrice);
            lottoView.printLottoPurchaseHistory(lottos);

            // 2. 당첨 결과 확인
            final int[] winningNumbers = lottoView.readLottoWinningNumbers();
            final Map<LottoRank, Long> lottoResult = lottoMachine.judge(lottos, winningNumbers);

            // 3. 수익률 계산
            final double profitRate = lottoMachine.calculate(lottoResult, totalPrice);
            lottoView.printLottoWinningResult(lottoResult, profitRate);

        } catch (final IllegalArgumentException e) {
            lottoView.printBusinessExceptionMessage(e.getMessage());

        } catch (final Exception e) {
            lottoView.printUnexpectedExceptionMessage();
        }
    }
}
