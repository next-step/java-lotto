package autoLotto;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Lottos lottos = new Lottos();

        Quantity quantity = new Quantity(inputView.inputAmount());
        int quantityQuantity = quantity.getQuantity();
        outputView.outputQuantity(quantityQuantity);

        for ( int i = 0 ; i < quantityQuantity ; i++) {
            lottos.addLotto(new Lotto());
        }
        outputView.outputLottos(lottos);

//        inputView.inputNumbers();

    }
}
