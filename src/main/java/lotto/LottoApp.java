package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;

public class LottoApp {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        LottoOrderDto lottoOrderDto = new LottoOrderDto(inputView.inputMoney());
        LottoOrderResultDto lottoOrderResultDto = LottoController.orderLotto(lottoOrderDto);
        ResultView.printLottoOrderResult(lottoOrderResultDto);

        LottoScoringDto lottoScoringDto = new LottoScoringDto(
                new LottoDto(inputView.inputWinnerNumbers()), lottoOrderResultDto);
        LottoScoringResultDto lottoScoringResultDto = LottoController.scoreLotto(lottoScoringDto);
        ResultView.printLottoScoringResult(lottoScoringResultDto);
    }
}
