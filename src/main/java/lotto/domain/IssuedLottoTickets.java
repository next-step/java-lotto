package lotto.domain;

public class IssuedLottoTickets {

    private final LottoTickets manualLottoTickets;
    private final LottoTickets autoLottoTickets;

    public IssuedLottoTickets(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        this.manualLottoTickets = manualLottoTickets;
        this.autoLottoTickets = autoLottoTickets;
    }

    public LottoTickets getManualLottoTickets() {
        return this.manualLottoTickets;
    }

    public LottoTickets getAutoLottoTickets() {
        return this.autoLottoTickets;
    }

    public int manualLottoTicketsSize() {
        return this.manualLottoTickets.size();
    }

    public int autoLottoTicketsSize() {
        return this.autoLottoTickets.size();
    }

}
