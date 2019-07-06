package com.java.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsGenerator {

    public static List<LottoTicket> automaticTicketsGenerator(LottoPurchase lottoPurchase) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoPurchase.getCountOfAutoLotto(); i++) {
            lottoTickets.add(new LottoTicket(LottoNumbersGenerator.automaticNumbersGenerator()));
        }
        return lottoTickets;
    }

    public static List<LottoTicket>  manualTicketsGenerator(LottoPurchase lottoPurchase) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoPurchase.getCountOfManualLotto(); i++) {
            lottoTickets.add(manualTicketsGenerator(lottoPurchase.getManualLottoNumbers(i)));
        }
        return lottoTickets;
    }

    public static LottoTicket manualTicketsGenerator(String manualNumbers) {
        return new LottoTicket(LottoNumbersGenerator.manualNumbersGenerator(manualNumbers));
    }

}
