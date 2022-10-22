package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final LottoNumberGenerator generator = new LottoNumberGenerator();

    public static List<LottoTicket> create(int numOfTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            lottoTickets.add(new LottoTicket(generator.getLottoNumbers()));
        }
        return lottoTickets;
    }

}
