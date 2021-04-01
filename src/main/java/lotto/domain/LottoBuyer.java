package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoBuyer {
    private final LottoTickets manualLottoTickets;
    private final LottoTickets autoLottoTickets;

    public LottoBuyer(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        this(new LottoTickets(manualLottoTickets), new LottoTickets(autoLottoTickets));
    }

    public LottoBuyer(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        this.manualLottoTickets = manualLottoTickets;
        this.autoLottoTickets = autoLottoTickets;
    }

    public int manualLottoTicketsCount() {
        return manualLottoTickets.count();
    }

    public int autoLottoTicketsCount() {
        return autoLottoTickets.count();
    }

    public LottoTickets allLottoTickets() {
        return manualLottoTickets.combine(autoLottoTickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer that = (LottoBuyer) o;
        return Objects.equals(manualLottoTickets, that.manualLottoTickets) && Objects.equals(autoLottoTickets, that.autoLottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoTickets, autoLottoTickets);
    }
}
