package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;

    private List<LottoTicket> lottoTickets;

    public List<LottoTicket> buyTickets(int price) {
        int lottoCount = price / LOTTO_PRICE;

        return generateAutoLotto(lottoCount);
    }

    public List<LottoTicket> generateAutoLotto(int lottoCount) {
        lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

    public Winner getWiner(List<LottoTicket> lottoTickets, String lastWeekWinningInput) {
        return new Winner(lottoTickets, lastWeekWinningInput);
    }
}
