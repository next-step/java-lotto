package autoLotto;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();
        Lottos lottos = new Lottos();

        Quantity quantity = new Quantity(inputView.inputAmount());
        int quantityQuantity = quantity.getQuantity();
        outputView.outputQuantity(quantityQuantity);

        for ( int i = 0 ; i < quantityQuantity ; i++) {
            lottos.addLotto(new Lotto());
        }
        outputView.outputLottos(lottos);

        double result = calculator.matchNumber(lottos, new Numbers(inputView.inputNumbers()), quantityQuantity * 1000);

        outputView.outputResult(result);
    }
}
