package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;

public class LottoMachine {
    private final PurchaseInfo purchaseInfo;
    private final RandomTicketMaker randomTicketMaker = new RandomTicketMaker();
    private final PickedTicketMaker pickedTicketMaker = new PickedTicketMaker();

    public LottoMachine(PurchaseInfo purchaseInfo) {
        validate(purchaseInfo);
        this.purchaseInfo = purchaseInfo;
    }

    private void validate(PurchaseInfo purchaseInfo) {
        if (purchaseInfo.getTotalTicketCount() < purchaseInfo.getPickedTicketCount()) {
            throw new IllegalArgumentException("구입금액보다 큰 수동로또 숫자 입력은 불가능합니다.");
        }
    }

    public LottoTickets makeLottoTickets() {
        LottoTickets userLottoTickets = randomTicketMaker.makeTickets(purchaseInfo);
        return userLottoTickets.createMergedTicket(pickedTicketMaker.makeTickets(purchaseInfo));
    }

}
