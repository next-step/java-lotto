package lotto.controller;

import lotto.constant.Lotto;
import lotto.domain.*;
import lotto.dto.LottoGameResultDto;
import lotto.utils.LottoNumberGenerator;

public class LottoController {

    public Lottoes purchaseLottoes(PurchaseAmount purchaseAmount) {
        return LottoNumberGenerator.create(purchaseAmount);
    }

    public LottoGameResultDto getLottoGameResult(Lottoes lottoes, WinningNumbers winningNumbers) {
        LottoGame lottoGame = new LottoGame(lottoes, winningNumbers);
        PurchaseAmount purchaseAmount = new PurchaseAmount(lottoes.getValue().size() * Lotto.PRICE);
        return new LottoGameResultDto(lottoGame.getResult(), purchaseAmount);
    }
}
