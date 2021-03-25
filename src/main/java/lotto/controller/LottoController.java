package lotto.controller;

import lotto.controller.dto.PurchaseLottoAutoRequest;
import lotto.controller.dto.PurchaseLottoAutoResponse;

public class LottoController {

    public PurchaseLottoAutoResponse purchaseLottoAutoTicket(PurchaseLottoAutoRequest request) {
        return new PurchaseLottoAutoResponse(1, new int[][]{{1, 2, 3, 4, 5, 6}});
    }
}
