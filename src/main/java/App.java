import infrastructure.LottoCalculator;
import service.LottoGameService;
import ui.Console;
import ui.GameReady;
import view.InputPriceView;
import view.InputWinningView;
import view.OutputResultView;

public class App {

    public static void main(String[] args) {
        InputPriceView priceView = GameReady.setPrice();

        LottoGameService game = new LottoGameService(priceView, new LottoCalculator());
        Console.showPurchase(game.getPurchaseCount());
        Console.showLottoNumber(game.getPurchasedLottos());

        InputWinningView winningView = GameReady.setWinning();
        OutputResultView result = game.start(winningView);

        Console.showResult(result);
    }
}
