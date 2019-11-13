package step2.serivce;

import step2.domain.*;

public class LottoService {
    public static LottoTickets buyTickets(int inputPrice) {
        Price price = new Price(inputPrice);

        int lottoCount = price.countLotto();

        return new LottoTickets(lottoCount);
    }

    public static Winner match(LottoTickets lottoTickets, String lastWeekWinningInput, LottoNum bonus) {
        return new Winner(lottoTickets, lastWeekWinningInput, bonus);
    }
}
