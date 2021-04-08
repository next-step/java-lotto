package lotto;

import lotto.domain.machine.RandomLottoGenerator;
import lotto.dto.LottoOrderDto;
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
        long money = inputView.inputMoney();
        int manualLottoCount = inputView.inputManualLottoCount();
        LottoOrderDto lottoOrderDto = new LottoOrderDto(money, inputView.inputManualLotto(manualLottoCount));
        LottoOrderResultDto lottoOrderResultDto = shoppingService.purchase(lottoOrderDto);
        ResultView.printLottoOrderResult(lottoOrderResultDto);

        LottoScoring scoringService =
                new LottoScoring(lottoOrderResultDto,
                        inputView.inputWinnerNumbers(),
                        inputView.inputBonusNumbers());
        ResultView.printLottoScoringResult(scoringService.getResult());
        ResultView.printLottoEarningRate(scoringService.getEarningRate());
    }
}
