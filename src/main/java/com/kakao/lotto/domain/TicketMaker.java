package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;

public interface TicketMaker {
    LottoTickets makeTickets(PurchaseInfo purchaseInfo);
}
