package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberRandomGenerator;

public class Game {
    private static final Amount TICKET_PRICE = new Amount(1000);

    private final LottoTickets lottoTickets;

    public Game(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static Game createByMoney(Amount money) {
        return createByMoneyAndGenerator(money, new LottoNumberRandomGenerator());
    }

    public static Game createByMoneyAndGenerator(Amount money, LottoNumberGenerator lottoNumberGenerator) {
        int countOfTicket = money.divide(TICKET_PRICE);

        return new Game(LottoTickets.createByGenerator(lottoNumberGenerator, countOfTicket));
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
