package lotto.controller;

import lotto.domain.machine.TestLottoGenerator;
import lotto.service.LottoScoring;
import lotto.service.LottoShopping;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;

public class LottoController {
    private static LottoShopping shoppingService =
            new LottoShopping(new TestLottoGenerator());
    private static LottoScoring scoringService = new LottoScoring();

    public static LottoOrderResultDto orderLotto(LottoOrderDto purchaseMoneyDto) {
        return shoppingService.purchase(purchaseMoneyDto);
    }

    public static LottoScoringResultDto scoreLotto(LottoScoringDto lottoScoringDto) {
        return scoringService.score(lottoScoringDto);
    }
}
