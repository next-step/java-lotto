package controller;

import model.LottoGame;
import service.LottoService;
import util.LottoNumberGenerator;
import view.InputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private int numberOfGames;
    private List<LottoGame> lottoGames;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        InputView inputView = new InputView();
        int purchasePrice = inputView.getPurchasePrice();
        numberOfGames = lottoService.calculateNumberOfGames(purchasePrice);
        lottoGames = lottoService.generateLottoGames(numberOfGames);
        inputView.printNumberOfGames(numberOfGames);
        inputView.printLottoGames(lottoGames);
    }


    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoService lottoService = new LottoService(lottoNumberGenerator);
        LottoController lottoController = new LottoController(lottoService);
        lottoController.run();
    }
}
