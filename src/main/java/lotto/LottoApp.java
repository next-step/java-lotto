package lotto;

import lotto.controller.LottoController;

import lotto.dto.LottoDrawDto;
import lotto.dto.LottoPurchaseMoneyDto;
import lotto.dto.LottoPurchasedDto;
import lotto.dto.LottoResultDto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        LottoPurchaseMoneyDto purchaseMoneyDto = new LottoPurchaseMoneyDto(inputView.inputMoney());
        LottoPurchasedDto lottoPurchasedDto = LottoController.purchaseLotto(purchaseMoneyDto);
        ResultView.printLottoPurchaseResult(lottoPurchasedDto);

        LottoDrawDto lottoDrawDto = new LottoDrawDto(lottoPurchasedDto,
                inputView.inputWinnerNumbers());
        LottoResultDto lottoResultDto = LottoController.drawLotto(lottoDrawDto);
        ResultView.printLottoDrawResult(lottoResultDto);
    }
}
