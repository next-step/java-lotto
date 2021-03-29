package lotto.controller;

import lotto.domain.machine.TestLottoGenerator;
import lotto.service.LottoScoringService;
import lotto.service.LottoShoppingService;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;

public class LottoController {
    private static LottoShoppingService shoppingService =
            new LottoShoppingService(new TestLottoGenerator());
    private static LottoScoringService scoringService = new LottoScoringService();

    public static LottoOrderResultDto orderLotto(LottoOrderDto purchaseMoneyDto) {
        return shoppingService.purchase(purchaseMoneyDto);
    }

    public static LottoScoringResultDto scoreLotto(LottoScoringDto lottoScoringDto) {
        return scoringService.score(lottoScoringDto);
    }
}
