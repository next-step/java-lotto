package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private final PurchaseInfo purchaseInfo;

    public LottoMachine(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    public LottoTickets makeLottoTickets() {
        List<LottoTicket> pickedLottoTickets = makePickedLottoTickets();
        List<LottoTicket> randomLottoTickets = makeRandomLottoTickets();
        List<LottoTicket> userLottoTickets = Stream.concat(pickedLottoTickets.stream(), randomLottoTickets.stream())
                .collect(Collectors.toList());
        return new LottoTickets(userLottoTickets);
    }

    private List<LottoTicket> makePickedLottoTickets() {
        return purchaseInfo.getPickedLotteries().stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> makeRandomLottoTickets() {
        return IntStream.range(0, purchaseInfo.getRandomTicketCount()).boxed()
                .map(i -> makeRandomLottoTicket())
                .collect(Collectors.toList());
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
