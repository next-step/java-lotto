package lotto;

import lotto.domain.machine.RandomLottoGenerator;
import lotto.domain.machine.TestLottoGenerator;
import lotto.service.LottoScoring;
import lotto.service.LottoShopping;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;

public class LottoApp {
    private static LottoShopping shoppingService =
            new LottoShopping(new RandomLottoGenerator());
    private static LottoScoring scoringService = new LottoScoring();

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        LottoOrderDto lottoOrderDto = new LottoOrderDto(inputView.inputMoney());
        LottoOrderResultDto lottoOrderResultDto = shoppingService.purchase(lottoOrderDto);
        ResultView.printLottoOrderResult(lottoOrderResultDto);

        LottoScoringDto lottoScoringDto = new LottoScoringDto(
                new LottoDto(inputView.inputWinnerNumbers(), inputView.inputBonusNumbers()), lottoOrderResultDto);
        LottoScoringResultDto lottoScoringResultDto = scoringService.score(lottoScoringDto);
        ResultView.printLottoScoringResult(lottoScoringResultDto);
    }
}
