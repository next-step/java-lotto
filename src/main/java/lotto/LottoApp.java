package lotto;

import lotto.domain.machine.RandomLottoGenerator;
import lotto.domain.shop.Money;
import lotto.dto.LottoOrderResultDto;
import lotto.service.LottoScoring;
import lotto.service.LottoShopping;
import lotto.view.InputView;
import lotto.view.ResultView;


public class LottoApp {
    private static LottoShopping shoppingService =
            new LottoShopping(new RandomLottoGenerator());

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);
        Money money = new Money(inputView.inputMoney());
        LottoOrderResultDto lottoOrderResultDto = shoppingService.purchase(money);
        ResultView.printLottoOrderResult(lottoOrderResultDto);

        LottoScoring scoringService =
                new LottoScoring(lottoOrderResultDto,
                        inputView.inputWinnerNumbers(),
                        inputView.inputBonusNumbers());
        ResultView.printLottoScoringResult(scoringService.getResult());
        ResultView.printLottoEarningRate(scoringService.getEarningRate());
    }
}
