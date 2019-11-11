package step2.serivce;

import step2.domain.Bonus;
import step2.domain.LottoTickets;
import step2.domain.Price;
import step2.domain.Winner;

public class LottoService {
    public LottoTickets buyTickets(int inputPrice) {
        Price price = new Price(inputPrice);

        int lottoCount = price.countLotto();;
        return getLottoTickets(lottoCount);
    }

    public LottoTickets getLottoTickets(int lottoCount) {
        return new LottoTickets(lottoCount);
    }

    public Winner getWinner(LottoTickets lottoTickets, String lastWeekWinningInput, Bonus bonus) {
        return new Winner(lottoTickets, lastWeekWinningInput, bonus);
    }
}
