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

    public LottoTickets buy(final long amount) {
        validateMinimumAmount(amount);

        buyAutoLottoTickets(getBuyAutoLottoTicketCount(amount, 0));
        return buyLottoTickets;
    }

    public LottoTickets buy(final long amount, String... autoLottoTicketArray) {
        validateMinimumAmount(amount);

        buyManualLottoTickets(autoLottoTicketArray);
        buyAutoLottoTickets(getBuyAutoLottoTicketCount(amount, autoLottoTicketArray.length));
        return buyLottoTickets;
    }

    private void validateMinimumAmount(final long amount) {
        if (amount < LottoTicket.PRIZE_AMOUNT) {
            throw new IllegalArgumentException("less then the minimum amount");
        }
    }

    private void buyManualLottoTickets(String[] autoLottoTickets) {
        List<LottoTicket> manualLottoTickets = Arrays.stream(autoLottoTickets)
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::generate)
                .collect(Collectors.toList());

        buyLottoTickets.addAll(manualLottoTickets);
    }

    private void buyAutoLottoTickets(final long count) {
        for (int i = 0; i < count; i++) {
            buyLottoTickets.add(lottoGenerator.generate());
        }
    }

    private long getBuyAutoLottoTicketCount(long amount, int manualLottoCount) {
        long count = getPurchaseCount(amount) - manualLottoCount;
        if (count < 0) {
            throw new IllegalArgumentException("not enough amount");
        }
        return count;
    }

    private long getPurchaseCount(long amount) {
        return Math.floorDiv(amount, LottoTicket.PRIZE_AMOUNT);
    }
}
