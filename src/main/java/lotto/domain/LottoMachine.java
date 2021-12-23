package lotto.domain;

import lotto.domain.strategy.AutomaticLottoTicketsGenerator;
import lotto.domain.strategy.ManualLottoTicketsGenerator;

public class LottoMachine {

    private LottoMachine() {
    }

    public static LottoTickets generateLottoTickets(LottoPurchaseInformation purchaseInfo) {
        ManualLottoTicketsGenerator manualGenerator = new ManualLottoTicketsGenerator(purchaseInfo.manuallyPickedLottoTickets());
        AutomaticLottoTicketsGenerator automaticGenerator = new AutomaticLottoTicketsGenerator(purchaseInfo.numberOfAutomaticTicket());
        return new LottoTickets(manualGenerator, automaticGenerator);
    }

}
