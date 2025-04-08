package Lotto.controller;

import Lotto.dto.RankResultDto;
import Lotto.model.LottoService;
import Lotto.model.NumberExtractor.FixedNumberExtractor;
import Lotto.model.NumberExtractor.NumberExtractor;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.List;

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

    public void start() {
        int purchaseAmount = this.inputView.getPurchaseAmount();
        int manualPurchaseNumber = this.inputView.getManualPurchaseNumber();
        List<List<Integer>> manualNumberList = this.inputView.getManualNumbers(manualPurchaseNumber);

        FixedNumberExtractor[] fixedExtractors = new FixedNumberExtractor[manualNumberList.size()];
        for(int i=0; i<manualNumberList.size(); i++){
            fixedExtractors[i] = new FixedNumberExtractor(manualNumberList.get(i));
        }

        lottoService = new LottoService(purchaseAmount, extractor, fixedExtractors);
        lottoService.draw();
        resultView.printBuyNum(lottoService.manualLottoNum(), lottoService.autoLottoNum());
        resultView.printLotto(lottoService.lottoList());

        List<Integer> winningNumbers = inputView.getWinnerNumbers();
        int bonusNumber = inputView.getBonusNumber();
        lottoService.decideWinning(winningNumbers, bonusNumber);
        resultView.printWinStatistics(RankResultDto.convertToDtos(lottoService.winningCountMap()),
                lottoService.profitRate());
    }
}
