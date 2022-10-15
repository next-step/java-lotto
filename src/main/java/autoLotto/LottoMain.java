package autoLotto;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Quantity quantity = new Quantity(inputView.inputAmount());
        outputView.outputQuantity(quantity.getQuantity());

//        inputView.inputNumbers();

    }
}
