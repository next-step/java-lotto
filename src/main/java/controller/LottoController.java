package controller;

import model.Lottos;
import model.Placement;
import model.Placements;
import model.Result;
import service.LottoService;
import util.LottoNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int purchasePrice = inputView.getPurchasePrice();
        Lottos lottos = lottoService.create(purchasePrice);
        resultView.printLottos(lottos);

        String winningNumbersStr = inputView.getLottoWinningNumbers();
        Result result = lottoService.getResult(lottos, winningNumbersStr);

        Placements placements = new Placements(List.of(
                new Placement(6, 2000000000),
                new Placement(5, 1500000),
                new Placement(4, 50000),
                new Placement(3, 5000),
                new Placement(0, 0)
        ));


//        for (LottoGame lottoGame : lottoGames) {
//            lottoResult.addGame(lottoGame);
//        }
//
//        List<String> lottoResultStat = lottoResult.getStatStrings();
//        resultView.printStat(lottoResultStat);
    }
}
