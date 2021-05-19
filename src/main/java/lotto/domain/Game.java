package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberRandomGenerator;

public class Game {
    private static final Amount TICKET_PRICE = new Amount(1000);

    private final LottoTickets lottoTickets;
    private final LottoWon lottoWon;

    public Game(LottoTickets lottoTickets, LottoWon lottoWon) {
        this.lottoTickets = lottoTickets;
        this.lottoWon = lottoWon;
    }

    public static Game createByMoney(Amount money, LottoWon lottoWon) {
        return createByMoneyAndGenerator(money, new LottoNumberRandomGenerator(), lottoWon);
    }

    public static Game createByMoneyAndGenerator(Amount money, LottoNumberGenerator lottoNumberGenerator, LottoWon lottoWon) {
        int countOfTicket = money.divide(TICKET_PRICE);

        return new Game(LottoTickets.createByGenerator(lottoNumberGenerator, countOfTicket), lottoWon);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
