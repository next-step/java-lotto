package com.java.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsGenerator {
    public static LottoTickets automaticTicketsGenerator(int amont) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amont; i++) {
            lottoTickets.add(new LottoTicket(LottoNumbersGenerator.automaticNumbersGenerator()));
        }
        return new LottoTickets(lottoTickets);
    }
}
