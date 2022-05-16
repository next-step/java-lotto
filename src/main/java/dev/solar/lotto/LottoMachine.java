package dev.solar.lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import dev.solar.lotto.domain.Lotto;
import dev.solar.lotto.domain.LottoNumber;
import dev.solar.lotto.domain.LottoTicket;
import dev.solar.lotto.domain.PrizeMoney;
import dev.solar.lotto.view.InputView;
import dev.solar.lotto.view.OutputView;

public class LottoMachine {

    public static void main(String[] args) {
        final int payment = InputView.inputPurchasingAmount();
        final Lotto lotto = Lotto.buyLottoTickets(payment);
        OutputView.printPurchaseAmount(lotto.getRemainingLottoTicket());
        while (lotto.isRemainNewLottoTickes()) {
            lotto.pick();
        }

        final List<LottoTicket> lottoTickets = lotto.getLottoTickets();
        lottoTickets.forEach(
                lottoTicket -> OutputView.printLotto(lottoTicket.getLottoNumbers())
        );

        final Set<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
        final TreeMap<PrizeMoney, Integer> winningResult = lotto.checkWinningResult(winningNumbers);
        OutputView.printResult(winningResult);
        OutputView.printProfitMargin(lotto);
    }

}
