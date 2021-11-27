package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;

import java.util.List;
import java.util.stream.Collectors;

public class PickedTicketMaker implements TicketMaker {

    @Override
    public LottoTickets makeTickets(PurchaseInfo purchaseInfo) {
        List<LottoTicket> lottoTickets = purchaseInfo.getPickedLotteries().stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }
}
