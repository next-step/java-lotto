package step2.domain;

import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    private LottoTickets lottoTickets;

    public LottoTickets buyTickets(int price) {
        int lottoCount = price / LOTTO_PRICE;

        return generateAutoLotto(lottoCount);
    }

    public LottoTickets generateAutoLotto(int lottoCount) {
        lottoTickets = new LottoTickets();

        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }

    public Winner getWiner(LottoTickets lottoTickets, String lastWeekWinningInput) {
        return new Winner(lottoTickets, lastWeekWinningInput);
    }
}
