package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.LottoNumberRandomGenerator;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTickets;

public class Game {
    private static final PositiveNumber TICKET_PRICE = new PositiveNumber(1000);

    private final LottoTickets autoLottoTickets;
    private final LottoTickets manualLottoTickets;
    private final LottoTickets allLottoTickets;

    private Game(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        this.autoLottoTickets = autoLottoTickets;
        this.manualLottoTickets = manualLottoTickets;
        this.allLottoTickets = autoLottoTickets.add(manualLottoTickets);
    }

    public static Game createByMoney(PositiveNumber money) {
        return createByMoneyAndGenerator(money, LottoNumberGenerator.DEFAULT_LOTTO_GENERATOR);
    }

    public static Game createWithManualTicketByMoney(LottoTickets manualLottoTickets, PositiveNumber money) {
        PositiveNumber countOfManualTicket = new PositiveNumber(manualLottoTickets.size());
        PositiveNumber countOfTicket = money.divide(TICKET_PRICE);

        if (countOfTicket.isUnder(countOfManualTicket)) {
            throw new IllegalArgumentException("금액 초과입니다.");
        }

        PositiveNumber countOfAutoTicket = countOfTicket.minus(countOfManualTicket);

        return new Game(
                LottoTickets.createByGenerator(LottoNumberGenerator.DEFAULT_LOTTO_GENERATOR, countOfAutoTicket),
                manualLottoTickets);
    }

    public static Game createByMoneyAndGenerator(PositiveNumber money, LottoNumberGenerator lottoNumberGenerator) {
        PositiveNumber countOfTicket = money.divide(TICKET_PRICE);

        return new Game(
                LottoTickets.createByGenerator(lottoNumberGenerator, countOfTicket),
                LottoTickets.EMPTY_LOTTO_TICKETS);
    }

    public LottoRanks match(LottoWon lottoWon) {
        return lottoWon.match(allLottoTickets);
    }

    public PositiveNumber totalPriceOfTickets() {
        return TICKET_PRICE.multiple(new PositiveNumber(allLottoTickets.size()));
    }

    public int sizeOfManualLottoTickets() {
        return manualLottoTickets.size();
    }

    public int sizeOfAutoLottoTickets() {
        return autoLottoTickets.size();
    }

    public LottoTickets getAllLottoTickets() {
        return allLottoTickets;
    }
}
