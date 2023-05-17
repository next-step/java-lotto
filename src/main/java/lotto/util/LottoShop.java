package lotto.util;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static List<LottoTicket> sell(int gameCount) {
        return buyAutoLottoTicket(gameCount, new ArrayList<>());
    }

    public static List<LottoTicket> sell(int gameCount, List<LottoTicket> manualLottoTickets) {
        List<LottoTicket> lottoTickets = manualLottoTickets;
        buyAutoLottoTicket(gameCount, manualLottoTickets);

        return lottoTickets;
    }

    private static List<LottoTicket> buyAutoLottoTicket(int gameCount, List<LottoTicket> buyLottoTickets) {
        List<LottoTicket> lottoTickets = buyLottoTickets;

        for(int i = 0; i < gameCount; i ++) {
            lottoTickets.add(new LottoTicket(LottoGenerate.initAutoLottoNumbers()));
        }

        return lottoTickets;
    }
}
