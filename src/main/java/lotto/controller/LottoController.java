package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.service.LottoService;

public class LottoController {

    private static LottoController LOTTO_CONTROLLER;
    private static LottoService LOTTO_SERVICE;

    private LottoController(LottoService lottoService) {
        LOTTO_SERVICE = lottoService;
    }

    public static LottoController getInstance() {
        if (LOTTO_CONTROLLER == null) {
            LOTTO_CONTROLLER = new LottoController(LottoService.getInstance());
        }
        return LOTTO_CONTROLLER;
    }

    public LottoTickets buyTickets(Integer money) {
        return LOTTO_SERVICE.buyLottoTickets(money);
    }

}
