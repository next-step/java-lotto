package lotto.domain.machine;

import lotto.domain.lotto.LottoNumberStrategy;
import lotto.ui.LottoMachineDto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoMoney lottoMoney;

    public LottoMachine(LottoMachineDto lottoGameDto) {
        this(lottoGameDto.getLottoMoney());
    }

    public LottoMachine(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public LottoTickets buy(LottoNumberStrategy lottoNumberStrategy) {
        int availableCount = lottoMoney.getAvailableBuyingCount();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < availableCount; i++) {
            LottoTicket lottoTicket = new LottoTicket(lottoNumberStrategy.get());
            lottoTickets.add(lottoTicket);
        }
        return new LottoTickets(lottoTickets);
    }
}
