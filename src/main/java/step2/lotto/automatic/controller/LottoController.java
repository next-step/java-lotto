package step2.lotto.automatic.controller;


import step2.lotto.automatic.domain.LottoMatch;
import step2.lotto.automatic.domain.LottoStatusEnum;
import step2.lotto.automatic.view.InputStep2View;
import step2.lotto.automatic.view.OuterStep2View;

import java.util.Map;

public class LottoController {

    private static LottoMatch lottoMatch;

    public static void main(String[] args) {
        int purchaseAmount = InputStep2View.inputValue();
        lottoMatch = new LottoMatch(purchaseAmount);
        lottoMatch.buyLottoNumber();

        OuterStep2View.printBuyLotto(lottoMatch.getLottoPurchaseCount());
        OuterStep2View.printAutoLottoNumbers(lottoMatch.getBuyLottoList());

        String inputLottoWinnerNumber = InputStep2View.inputWinningLottoNumbers();
        Map<Integer, LottoStatusEnum> resunlt = lottoMatch.getLottoResult(inputLottoWinnerNumber);

        OuterStep2View.printLottoResult(resunlt);
    }
}
