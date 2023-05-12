package lotto.util;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static List<LottoTicket> lottoTickets;

    public static List<LottoTicket> sell(int gameCount) {
        lottoTickets = new ArrayList<>();
        buyAutoLottoTicket(gameCount);

        return lottoTickets;
    }

    public static List<LottoTicket> sell(List<LottoTicket> manualLottoTickets, int gameCount) {
        lottoTickets = manualLottoTickets;
        buyAutoLottoTicket(gameCount);

        return lottoTickets;
    }

    private static void buyAutoLottoTicket(int gameCount) {

        for(int i = 0; i < gameCount; i ++) {
            lottoTickets.add(new LottoTicket(LottoGenerate.initAutoLottoNumbers()));
        }
    }
}
