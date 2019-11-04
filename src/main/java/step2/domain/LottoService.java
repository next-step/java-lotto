package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<LottoTicket> lottoTickets;

    public List<LottoTicket> buyTickets(int price) {
        int lottoCount = price/1000;

        return generateAutoLotto(lottoCount);
    }

    public List<LottoTicket> generateAutoLotto(int lottoCount) {
        lottoTickets = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

    public Winner getWiner(LottoTicket lastWeekWinningNumber) {
        return new Winner();
    }
}
