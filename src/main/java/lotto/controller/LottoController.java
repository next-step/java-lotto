package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.dto.OrderRequest;
import lotto.service.LottoVendingMachine;

public class LottoController {

    private static final LottoController LOTTO_CONTROLLER = new LottoController();

    private final LottoVendingMachine lottoVendingMachine;

    private LottoController() {
        this.lottoVendingMachine = LottoVendingMachine.getInstance();
    }

    public static LottoController getInstance() {
        return LOTTO_CONTROLLER;
    }

    public LottoTickets buy(OrderRequest request) {
        return lottoVendingMachine.sell(request.getAmount());
    }
}
