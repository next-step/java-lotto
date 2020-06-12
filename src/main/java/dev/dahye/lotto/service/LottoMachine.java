package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoOrder;
import dev.dahye.lotto.domain.LottoTicket;
import dev.dahye.lotto.domain.LottoTickets;

import java.util.List;

public class LottoMachine {
    private final LottoTickets lottoTickets;
    private final LottoOrder lottoOrder;

    public LottoMachine(LottoOrder lottoOrder, List<LottoTicket> manualLottoTickets) {
        validateCountOfManualLottoTickets(lottoOrder, manualLottoTickets);
        this.lottoOrder = lottoOrder;
        lottoTickets = LottoTickets.multiIssued(lottoOrder.getCountOfAutoLotto(), manualLottoTickets);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    private void validateCountOfManualLottoTickets(LottoOrder lottoOrder, List<LottoTicket> manualLottoTickets) {
        if (manualLottoTickets.size() != lottoOrder.getCountOfManualLotto()) {
            throw new IllegalArgumentException("수동 로또 갯수 만큼 로또 티켓을 입력해주세요.");
        }
    }
}
