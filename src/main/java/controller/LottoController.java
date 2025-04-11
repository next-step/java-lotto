package controller;

import model.*;
import service.LottoService;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int purchasePrice = inputView.getPurchasePrice();
        Lottos lottos = lottoService.create(purchasePrice);

        resultView.printLottos(lottos);

        String winningNumbersStr = inputView.getLottoWinningNumbers();
        LottoResult result = lottoService.result(lottos, winningNumbersStr);

        Placements placements = new Placements(List.of(
                new Placement(6, 2_000_000_000),
                new Placement(5, 1_500_000),
                new Placement(4, 50_000),
                new Placement(3, 5_000),
                new Placement(0, 0)
        ));

        resultView.printResult(result, placements);
    }
}
