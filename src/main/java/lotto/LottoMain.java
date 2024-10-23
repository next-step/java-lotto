package lotto;

public class LottoMain {

    public static void main(String[] args) {

        int amount = InputView.inputPurchaseAmount();

        Lottos lottos = new Lottos(amount);

        int quantity = lottos.returnPurchaseQuantity();

        ResultView.printQuantity(quantity);

        ResultView.printLottos(lottos.getLottoList());

        Lotto lastWinningLotto = new Lotto(InputView.inputLastWinningNumbers());
        System.out.println();

        LottoResults lottoResults = lottos.createLottoResults(lastWinningLotto);
        ResultView.printResult(lottoResults, amount);
    }
}
