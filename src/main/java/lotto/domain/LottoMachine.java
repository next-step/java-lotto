package lotto.domain;

import lotto.domain.strategy.AutomaticLottoTicketsGenerator;
import lotto.domain.strategy.ManualLottoTicketsGenerator;

public class LottoMachine {

    public static LottoTickets generateLottoTickets(LottoPurchaseInformation purchaseInfo) {
        ManualLottoTicketsGenerator manualGenerator = new ManualLottoTicketsGenerator(purchaseInfo.manuallyPickedLottoTickets(), purchaseInfo.lottoTicketPrice());
        AutomaticLottoTicketsGenerator automaticGenerator = new AutomaticLottoTicketsGenerator(purchaseInfo.numberOfAutomaticTicket(), purchaseInfo.lottoTicketPrice());
        return new LottoTickets(manualGenerator, automaticGenerator);
    }

}
