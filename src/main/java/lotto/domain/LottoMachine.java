package lotto.domain;

import lotto.domain.lottoGenerator.AutomaticLottoTicketsGenerator;
import lotto.domain.lottoGenerator.ManualLottoTicketsGenerator;

public class LottoMachine {

    private LottoMachine() {
    }

    public static LottoTickets generateLottoTickets(LottoPurchaseInformation purchaseInfo) {
        ManualLottoTicketsGenerator manualGenerator = new ManualLottoTicketsGenerator(purchaseInfo.manuallyPickedLottoTickets());
        AutomaticLottoTicketsGenerator automaticGenerator = new AutomaticLottoTicketsGenerator(purchaseInfo.numberOfAutomaticTicket());
        return new LottoTickets(manualGenerator.generate(), automaticGenerator.generate());
    }

}
