package dev.solar.lotto;

import java.util.List;
import java.util.Set;

import dev.solar.lotto.domain.Lotto;
import dev.solar.lotto.domain.LottoTicket;
import dev.solar.lotto.domain.ResultBoard;
import dev.solar.lotto.domain.WinningLotto;
import dev.solar.lotto.view.InputView;
import dev.solar.lotto.view.OutputView;

public class LottoGame {

    public static void main(String[] args) {
        final int payment = InputView.inputPurchasingAmount();
        final Lotto lotto = Lotto.buyLottoTickets(payment);
        OutputView.printPurchaseAmount(lotto.getRemainingLottoTicket());
        while (lotto.isRemainNewLottoTickets()) {
            lotto.pick();
        }

        final List<LottoTicket> lottoTickets = lotto.getLottoTickets();
        lottoTickets.forEach(
                lottoTicket -> OutputView.printLotto(lottoTicket.getLottoNumbers())
        );

        final Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        final int bonusNumber = InputView.inputBonusNumber();
        final ResultBoard resultBoard = lotto.checkWinningResult(new WinningLotto(winningNumbers, bonusNumber));
        OutputView.printResult(resultBoard);
        OutputView.printProfitMargin(lotto, resultBoard);
    }

}
