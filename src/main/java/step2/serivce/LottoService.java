package step2.serivce;

import step2.domain.LottoTickets;
import step2.domain.Winner;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;

    public LottoTickets buyTickets(int price) {
        int lottoCount = price / LOTTO_PRICE;

        return getLottoTickets(lottoCount);
    }

    public LottoTickets getLottoTickets(int lottoCount) {
        return new LottoTickets(lottoCount);
    }

    public Winner getWiner(LottoTickets lottoTickets, String lastWeekWinningInput) {
        return new Winner(lottoTickets, lastWeekWinningInput);
    }
}
