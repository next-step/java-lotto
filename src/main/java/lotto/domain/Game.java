package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberRandomGenerator;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTickets;

public class Game {
    private static final PositiveNumber TICKET_PRICE = new PositiveNumber(1000);

    private final LottoTickets lottoTickets;

    public Game(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static Game createByMoney(PositiveNumber money) {
        return createByMoneyAndGenerator(money, new LottoNumberRandomGenerator());
    }

    public static Game createByMoneyAndGenerator(PositiveNumber money, LottoNumberGenerator lottoNumberGenerator) {
        PositiveNumber countOfTicket = money.divide(TICKET_PRICE);

        return new Game(LottoTickets.createByGenerator(lottoNumberGenerator, countOfTicket));
    }

    public LottoRanks match(LottoWon lottoWon) {
        return lottoWon.match(lottoTickets);
    }

    public PositiveNumber totalPriceOfTickets() {
        return TICKET_PRICE.multiple(new PositiveNumber(lottoTickets.size()));
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
