package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public static List<LottoTicket> createLottoTickets(int numOfTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator.getLottoNumbers()));
        }
        return lottoTickets;
    }

}
