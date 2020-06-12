package study.step4.dto;

import study.step4.domain.LottoTicket;
import study.step4.domain.LottoTickets;
import study.step4.domain.WinningRanks;

import java.util.List;

public class LottoOutputDto{
    private LottoTickets lottoTickets;
    private long autoLottoAmount;
    private long manualLottoAmount;
    private WinningRanks winningRanks;

    public LottoOutputDto(LottoTickets lottoTickets, long autoLottoAmount, long manualLottoAmount) {
        this.lottoTickets = lottoTickets;
        this.autoLottoAmount = autoLottoAmount;
        this.manualLottoAmount = manualLottoAmount;
    }

    public LottoOutputDto(WinningRanks winningRanks){
        this.winningRanks = winningRanks;
    }

    public long getAutoLottoAmount() {
        return autoLottoAmount;
    }

    public long getManualLottoAmount() {
        return manualLottoAmount;
    }

    public List<LottoTicket> getlottoTickets() {
        return lottoTickets.getLottoTickets();
    }
}
