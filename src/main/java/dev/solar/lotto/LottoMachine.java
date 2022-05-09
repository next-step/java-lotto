package dev.solar.lotto;

import java.util.List;

import dev.solar.lotto.view.InputView;
import dev.solar.lotto.view.OutputView;

public class LottoMachine {

    public static void main(String[] args) {
        final int payment = InputView.inputPurchasingAmount();
        final Lotto lotto = Lotto.buyLottoTickets(payment);
        OutputView.printPurchaseAmount(lotto.getPurchaseAmount());
        while (lotto.isRemainNewLottoTickes()) {
            lotto.pick();
        }

        final List<LottoTicket> lottoTickets = lotto.getLottoTickets();
        lottoTickets.forEach(
                lottoTicket -> OutputView.printLotto(lottoTicket.getLottoNumbers())
        );
    }

}
