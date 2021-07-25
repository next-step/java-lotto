package lotto.lotto;

import java.util.Objects;

public class LottoBundle {
    private final LottoTickets autoLottoTickets;
    private final LottoTickets manualLottoTickets;

    private LottoBundle(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        validate(autoLottoTickets, manualLottoTickets);
        this.autoLottoTickets = autoLottoTickets;
        this.manualLottoTickets = manualLottoTickets;
    }

    private void validate(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        if (Objects.isNull(autoLottoTickets) || Objects.isNull(manualLottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    public static LottoBundle init(LottoTickets autoLottoTickets, LottoTickets manualLottoTickets) {
        return new LottoBundle(autoLottoTickets, manualLottoTickets);
    }
}
