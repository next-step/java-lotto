package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Clerk {

    private final LottoMachine lottoMachine;

    public Clerk(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTicket buyTicket(PurchaseAmount purchaseAmount, List<String> manuallyWrittenNumbers) {
        if (purchaseAmount.getManuallyPurchaseAmount() != manuallyWrittenNumbers.size()) {
            throw new IllegalArgumentException("수동 구매하는 티켓 개수가 상이합니다.");
        }
        LottoTicket autoTicket = lottoMachine.printTicket(purchaseAmount.getAutomaticallyPurchaseAmount());
        LottoTicket manualTicket = LottoTicket.of(manuallyWrittenNumbers.stream().map(Lotto::from)
                .collect(Collectors.toList()));
        return manualTicket.plus(autoTicket);
    }
}
