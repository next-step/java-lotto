package step2;

import step2.controller.LottoController;

public class App {
    public static void main(String[] args) {
        TheMethodOfPurchase theMethodOfPurchase = new PurchaseScanner();
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();
        LottoNumberGenerator winningNumberGenerator = new ManualNumberGenerator();
        LottoController lottoController = new LottoController(theMethodOfPurchase, lottoNumberGenerator, winningNumberGenerator);

        lottoController.buyLotto();
        lottoController.checkWinningNumbers();
        lottoController.showResult();
    }
}
