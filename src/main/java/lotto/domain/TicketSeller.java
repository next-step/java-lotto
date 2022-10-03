package lotto.domain;

public class TicketSeller {
    private static final Money TICKET_PRICE = new Money(1_000);
    private static final TicketMachine TICKET_MACHINE = new TicketMachine();

    public static void sellTicketTo(User user) {
        while (user.hasEnoughMoney(TICKET_PRICE)) {
            user.buyTicket(TICKET_MACHINE.createLottoTicket(new RandomNumberGenerationStrategy()), TICKET_PRICE);
        }
    }

    public static void verifyRankFor(User user, LottoResult result) {
        user.getLottoTickets().stream()
            .map(ticket -> LottoGameRank.findRank(ticket, result))
            .forEach(System.out::println); // TODO 결과 객체 반환할 것
    }
}
