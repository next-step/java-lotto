package study.step4.dto;

import study.step4.domain.LottoTicket;
import study.step4.domain.LottoTickets;

import java.util.List;

public class LottoOutputDto{

    private final LottoTickets lottoTickets;
    private final long autoLottoAmount;
    private final long manualLottoAmount;

    public LottoOutputDto(LottoTickets lottoTickets,
                          long autoLottoAmount, long manualLottoAmount) {
        this.lottoTickets = lottoTickets;
        this.autoLottoAmount = autoLottoAmount;
        this.manualLottoAmount = manualLottoAmount;
    }

    public LottoTickets getObjectLottoTickets() {
        return lottoTickets;
    }

    public List<LottoTicket> getlottoTickets(){
        return lottoTickets.getLottoTickets();
    }

    public long getAutoLottoAmount() {
        return autoLottoAmount;
    }

    public long getManualLottoAmount() {
        return manualLottoAmount;
    }
}
