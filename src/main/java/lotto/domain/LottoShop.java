package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 로또 티켓을 관리
 */
public class LottoShop {
    private static final Money PRICE_PER_TICKET = new Money(1000);
    private static final LottoAutoGenerator LOTTO_AUTO_GENERATOR = new LottoAutoGenerator();
    private final Money purchasePrice;
    private final TicketAmount totalTicketAmount;
    private final TicketAmount manualTicketAmount;
    private final List<LottoTicket> lottoTickets;

    public LottoShop(Money purchasePrice, TicketAmount totalTicketAmount, TicketAmount manualTicketAmount, List<LottoTicket> manualLotto) {
        this.purchasePrice = purchasePrice;
        this.totalTicketAmount = totalTicketAmount;
        this.manualTicketAmount = manualTicketAmount;

        List<LottoTicket> autoLotto = sellAutoLottoTicket(totalTicketAmount.minus(manualTicketAmount));
        this.lottoTickets = Stream.concat(manualLotto.stream(), autoLotto.stream())
                .collect(Collectors.toList());
    }

    public static TicketAmount validateAndGetTotalTicketAmount(Money price, TicketAmount manualAmount) {
        TicketAmount totalAmount = calculateTicketAmount(price);
        validateManualTicketAmount(totalAmount, manualAmount);
        return totalAmount;
    }

    private static TicketAmount calculateTicketAmount(Money price) {
        return new TicketAmount(price.getPrice() / PRICE_PER_TICKET.getPrice());
    }

    private static void validateManualTicketAmount(TicketAmount total, TicketAmount manual) {
        if (manual.isGreaterThan(total)) {
            throw new IllegalArgumentException("수동 로또의 갯수가 전체 로또 갯수를 넘을 수 없습니다.");
        }
    }

    public List<LottoTicket> sellAutoLottoTicket(TicketAmount amount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < amount.getAmount(); i++) {
            tickets.add(LOTTO_AUTO_GENERATOR.generateLottoTicket());
        }
        return tickets;
    }

    public List<List<Integer>> getLottoTicketsNumber() {
        List<List<Integer>> lottos = new ArrayList<>();
        lottoTickets.forEach(l -> lottos.add(l.getNumbers()));
        return lottos;
    }

    public int getPurchasePrice() {
        return this.purchasePrice.getPrice();
    }

    public int getTotalTicketAmount() {
        return totalTicketAmount.getAmount();
    }

    public int getManualTicketAmount() {
        return manualTicketAmount.getAmount();
    }

    public int getAutoTicketAmount() {
        return totalTicketAmount.getAmount() - manualTicketAmount.getAmount();
    }
}
