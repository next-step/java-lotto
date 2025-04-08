package controller;

import model.LottoGame;
import model.LottoResult;
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
        List<LottoGame> lottoGames;
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int purchasePrice = inputView.getPurchasePrice();

        int numberOfGames = lottoService.calculateNumberOfGames(purchasePrice);
        lottoGames = lottoService.generateLottoGames(numberOfGames);

        inputView.printNumberOfGames(numberOfGames);
        inputView.printLottoGames(lottoGames);

        String lottoNumberString = inputView.getLottoWinningNumbers();
        List<Integer> lottoNumbers = lottoService.getLottoNumbers(lottoNumberString);
        LottoResult lottoResult = new LottoResult(lottoNumbers);

        for (LottoGame lottoGame : lottoGames) {
            lottoResult.addGame(lottoGame);
        }

        List<String> lottoResultStat = lottoResult.getStatStrings();
        resultView.printStat(lottoResultStat);
    }


    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoService lottoService = new LottoService(lottoNumberGenerator);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.run();
    }
}
