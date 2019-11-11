package step2.serivce;

import step2.domain.LottoTickets;
import step2.domain.Price;

public class LottoService {
    public LottoTickets buyTickets(int inputPrice) {
        Price price = new Price(inputPrice);

        int lottoCount = price.countLotto();

        return new LottoTickets(lottoCount);
    }
}
