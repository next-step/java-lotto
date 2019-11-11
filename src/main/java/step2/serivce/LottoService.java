package step2.serivce;

import step2.domain.Bonus;
import step2.domain.LottoTickets;
import step2.domain.Winner;

import static step2.domain.LottoTicket.LOTTO_PRICE;

public class LottoService {
    public LottoTickets buyTickets(int price) {
        checkPrice(price);

        int lottoCount = price / LOTTO_PRICE;
        return getLottoTickets(lottoCount);
    }

    private void checkPrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다");
        }
    }

    public LottoTickets getLottoTickets(int lottoCount) {
        return new LottoTickets(lottoCount);
    }

    public Winner getWinner(LottoTickets lottoTickets, String lastWeekWinningInput, Bonus bonus) {
        return new Winner(lottoTickets, lastWeekWinningInput, bonus);
    }
}
