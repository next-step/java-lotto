package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomTicketMaker implements TicketMaker {

    @Override
    public LottoTickets makeTickets(PurchaseInfo purchaseInfo) {
        List<LottoTicket> lottoTickets = IntStream.range(0, purchaseInfo.getRandomTicketCount()).boxed()
                .map(i -> makeRandomLottoTicket())
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    private LottoTicket makeRandomLottoTicket() {
        Set<LottoNumber> pickedNumber = shuffledLottoNumber().stream()
                .limit(LottoTicket.LOTTO_SIZE)
                .collect(Collectors.toSet());
        return new LottoTicket(pickedNumber);
    }

    private List<LottoNumber> shuffledLottoNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.getBaseLotto());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
