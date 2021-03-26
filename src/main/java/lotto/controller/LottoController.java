package lotto.controller;

import lotto.domain.policy.TestRandomPolicy;
import lotto.dto.LottoDrawDto;
import lotto.dto.LottoPurchaseMoneyDto;
import lotto.dto.LottoPurchasedDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;

public class LottoController {

    private static LottoService lottoService = new LottoService(new TestRandomPolicy());

    public static LottoPurchasedDto purchaseLotto(LottoPurchaseMoneyDto purchaseMoneyDto) {
        return lottoService.purchase(purchaseMoneyDto);
    }

    public static LottoResultDto drawLotto(LottoDrawDto lottoDrawDto) {
        return lottoService.draw(lottoDrawDto);
    }
}
