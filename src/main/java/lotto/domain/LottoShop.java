package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoShop {

    private final LottoTickets buyLottoTickets;
    private final LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.buyLottoTickets = new LottoTickets();
    }

    public LottoTickets buy(final int amount, final String... manualLottoTicketsArgs) {
        validateMinimumAmount(amount);

        int availableTicketCount = getAvailableTicketCount(amount);
        int buyManualTicketCount = buyManualLottoTickets(manualLottoTicketsArgs);
        int remainAvailableTicketCount = getRemainAvailableTicketCount(availableTicketCount, buyManualTicketCount);

        buyAutoLottoTickets(remainAvailableTicketCount);
        return buyLottoTickets;
    }

    private void validateMinimumAmount(final int amount) {
        if (amount < LottoTicket.PRIZE_AMOUNT) {
            throw new IllegalArgumentException("less then the minimum amount");
        }
    }

    private int getAvailableTicketCount(final int amount) {
        return Math.floorDiv(amount, LottoTicket.PRIZE_AMOUNT);
    }

    private int buyManualLottoTickets(final String[] autoLottoTickets) {
        List<LottoTicket> manualLottoTickets = Arrays.stream(autoLottoTickets)
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::generate)
                .collect(Collectors.toList());

        buyLottoTickets.addAll(manualLottoTickets);
        return manualLottoTickets.size();
    }

    private int getRemainAvailableTicketCount(final int availableTicketCount, final int buyManualTicketCount) {
        int count = availableTicketCount - buyManualTicketCount;
        if (count < 0) {
            throw new IllegalArgumentException("not enough amount");
        }
        return count;
    }

    private void buyAutoLottoTickets(final int count) {
        for (int i = 0; i < count; i++) {
            buyLottoTickets.add(lottoGenerator.generate());
        }
    }
}
