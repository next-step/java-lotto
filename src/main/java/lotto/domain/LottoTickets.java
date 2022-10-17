package lotto.domain;

import lotto.util.LottoNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();

    public static List<LottoTicket> createLottoTickets(LottoCount lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottoTickets.add(new LottoTicket(lottoNumberMaker.getLottoNumbers()));
        }
        return lottoTickets;
    }

}
