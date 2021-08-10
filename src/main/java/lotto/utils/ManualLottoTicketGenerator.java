package lotto.utils;

import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class ManualLottoTicketGenerator implements LottoTicketGenerator {
    @Override
    public LottoTicket execute() {
        return LottoTicket.of(InputView.getManualLottoNumber());
    }
}
