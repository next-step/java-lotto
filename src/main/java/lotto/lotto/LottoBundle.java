package lotto.lotto;

public class LottoBundle {
    private final LottoTickets autoLottoTickets;
    private final LottoTickets manualLottoTickets;

    private LottoBundle(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        this.autoLottoTickets = autoLottoTickets;
        this.manualLottoTickets = manualLottoTickets;
    }

    public static LottoBundle init(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        return new LottoBundle(autoLottoTickets, manualLottoTickets);
    }
}
