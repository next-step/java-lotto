package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberRandomGenerator;

public class Game {
    private static final PositiveInteger TICKET_PRICE = new PositiveInteger(1000);

    private final LottoTickets lottoTickets;

    public Game(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static Game createByMoney(PositiveInteger money) {
        return createByMoneyAndGenerator(money, new LottoNumberRandomGenerator());
    }

    public static Game createByMoneyAndGenerator(PositiveInteger money, LottoNumberGenerator lottoNumberGenerator) {
        int countOfTicket = money.divide(TICKET_PRICE);

        return new Game(LottoTickets.createByGenerator(lottoNumberGenerator, countOfTicket));
    }

    public LottoRanks match(LottoWon lottoWon) {
        return lottoWon.match(lottoTickets);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public PositiveInteger totalPriceOfTickets() {
        return TICKET_PRICE.multiple(lottoTickets.size());
    }
}
