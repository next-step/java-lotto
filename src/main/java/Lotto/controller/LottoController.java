package Lotto.controller;

import Lotto.dto.RankResultDto;
import Lotto.model.LottoService;
import Lotto.model.NumberExtractor.NumberExtractor;
import Lotto.view.InputView;
import Lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final NumberExtractor extractor;
    private LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView, NumberExtractor extractor) {
        this.extractor = extractor;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start(){
        int purchaseAmount = this.inputView.getPurchaseAmount();
        lottoService = new LottoService(purchaseAmount, extractor);
        lottoService.draw();
        resultView.printBuyNum(lottoService.lottoNum());
        resultView.printLotto(lottoService.lottoList());

        lottoService.decideWinning(inputView.getWinnerNumbers());
        resultView.printWinStatistics(RankResultDto.convertToDtos(lottoService.winningCountMap()),
                lottoService.profitRate());
    }
}
